package com.github.byference.effective.io.zip;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZipOperationTest
 * 测试图片大小：624 KB
 * FILE_SIZE 为 {@link File#length} = 630936
 * <p>
 * link: https://juejin.im/post/5d5626cdf265da03a65312be
 *
 * @author byference
 * @since 2019-09-15
 */
public class ZipOperationTest {

    private static final String JPG_PATH = "E:\\test.jpg";
    private static final String ZIP_PATH = "E:\\tests.zip";
    private static final long FILE_SIZE = new File(JPG_PATH).length();
    private static final String FILE_NAME = "test";


    @Test
    public void zipFilePip() {

        long startTime = System.currentTimeMillis();
        try (WritableByteChannel writableByteChannel = Channels.newChannel(new FileOutputStream(ZIP_PATH))) {

            Pipe pipe = Pipe.open();
            CompletableFuture.runAsync(() -> {
                try (ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(pipe.sink()));
                     WritableByteChannel out = Channels.newChannel(zos)) {

                    for (int i = 0; i < 10; i++) {
                        zos.putNextEntry(new ZipEntry(FILE_NAME + i + ".jpg"));
                        FileChannel jpgChannel = new FileInputStream(new File(JPG_PATH)).getChannel();
                        jpgChannel.transferTo(0, FILE_SIZE, out);
                        jpgChannel.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 获取读通道
            ReadableByteChannel readableByteChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(((int) FILE_SIZE) * 10);
            while (readableByteChannel.read(buffer) >= 0) {
                buffer.flip();
                writableByteChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("执行结束，耗时 %s ms\n", System.currentTimeMillis() - startTime);
        // 执行结束，耗时 526 ms
    }


    @Test
    public void zipFileMap() {

        long startTime = System.currentTimeMillis();
        File zipFIle = new File(ZIP_PATH);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFIle));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOutputStream)) {

            for (int i = 0; i < 10; i++) {

                zipOutputStream.putNextEntry(new ZipEntry(FILE_NAME + i + ".jpg"));
                MappedByteBuffer mappedByteBuffer = new RandomAccessFile(JPG_PATH, "r")
                        .getChannel().map(FileChannel.MapMode.READ_ONLY, 0, FILE_SIZE);
                writableByteChannel.write(mappedByteBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("执行结束，耗时 %s ms\n", System.currentTimeMillis() - startTime);
        // 执行结束，耗时 259 ms
    }


    @Test
    public void zipFileChannel() {

        long startTime = System.currentTimeMillis();
        File zipFIle = new File(ZIP_PATH);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFIle));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOutputStream)) {

            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_PATH).getChannel()) {
                    zipOutputStream.putNextEntry(new ZipEntry(FILE_NAME + i + ".jpg"));

                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("执行结束，耗时 %s ms\n", System.currentTimeMillis() - startTime);
        // 执行结束，耗时 252 ms
    }


    @Test
    public void zipFileBuffer() {

        long startTime = System.currentTimeMillis();
        File zipFIle = new File(ZIP_PATH);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFIle));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream)) {

            for (int i = 0; i < 10; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_PATH))) {
                    zipOutputStream.putNextEntry(new ZipEntry(FILE_NAME + i + ".jpg"));

                    int temp;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(temp);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("执行结束，耗时 %s ms\n", System.currentTimeMillis() - startTime);
        // 执行结束，耗时 502 ms
    }


    @Test
    public void zipFileNoBuffer() {

        long startTime = System.currentTimeMillis();
        File zipFIle = new File(ZIP_PATH);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFIle))) {

            for (int i = 0; i < 10; i++) {
                try (FileInputStream inputStream = new FileInputStream(JPG_PATH)) {
                    zipOutputStream.putNextEntry(new ZipEntry(FILE_NAME + i + ".jpg"));

                    int temp;
                    while ((temp = inputStream.read()) != -1) {
                        zipOutputStream.write(temp);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("执行结束，耗时 %s ms\n", System.currentTimeMillis() - startTime);
        // 执行结束，耗时 14730 ms
    }

}
