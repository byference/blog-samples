package com.github.byference.async;

import com.github.byference.common.ThrowableHandle;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @author byference
 * @since 2019/05/04
 */
public class CompletableFutureTest {

    /**
     * 创建线程池
     */
    private ExecutorService executor = Executors.newFixedThreadPool(10);


    /**
     * 测试 completableFuture
     * @see CompletableFuture
     */
    @Test
    public void completableFutureTest() {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::getMessage);
        completableFuture.whenComplete((message, throwable) -> {
            System.out.printf("message: [ %s ]\n", message);
            if (Objects.nonNull(throwable)) {
                System.out.printf("error: [ %s ]\n", throwable);
            }
        });

        // get
        execute(() -> {
            String message = completableFuture.get();
            System.out.printf("future 返回数据[ %s ]\n", message);
        });

    }


    /**
     * 测试 future
     * @see Future
     */
    @Test
    public void futureTest() {

        Future<String> future = executor.submit(CompletableFutureTest::getMessage);

        // 设置超时时间
        execute(() -> future.get(1, TimeUnit.SECONDS));

        // 无超时时间
        execute(() -> {
            String message = future.get();
            System.out.printf("future 返回数据[ %s ]\n", message);
        });
    }


    /**
     * 休眠3s后返回一段 {@link String}
     * @return "hello future"
     */
    private static String getMessage() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello future";
    }


    /**
     * 用于统一处理异常
     * @param handle {@link ThrowableHandle}
     */
    private void execute(ThrowableHandle handle) {

        try {
            handle.handle();
        } catch (Exception e) {
            System.err.printf("异常[ %s ]\n", e);
        }
    }


}
