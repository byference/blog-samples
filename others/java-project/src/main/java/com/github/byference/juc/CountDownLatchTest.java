package com.github.byference.juc;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * {@link CountDownLatch} Test
 *
 * @author byference
 * @since 2019/05/18
 */
public class CountDownLatchTest {



    @Test
    public void countDownLatchTest() throws Exception {

        int threadPoolSize = 30;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        CountDownLatch countDownLatch = new CountDownLatch(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            executor.submit(new Task(countDownLatch));
        }

        countDownLatch.await();
        System.out.println("所有线程执行完毕...");

    }


    @AllArgsConstructor
    class Task implements Runnable {

        private CountDownLatch countDownLatch;

        @Override
        public void run() {

            int random = new Random().nextInt(5);
            try {
                TimeUnit.SECONDS.sleep(random);
                System.out.printf("[ %s ] 休眠 %s s后 执行完成...\n", Thread.currentThread().getName(), random);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }



}
