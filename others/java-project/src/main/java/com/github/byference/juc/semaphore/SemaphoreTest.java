package com.github.byference.juc.semaphore;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author byference
 * @since 2019/05/26
 */
public class SemaphoreTest {


    @Test
    public void semaphoreTest1() throws Exception {

        int threadPoolSize = 6;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        CountDownLatch countDownLatch = new CountDownLatch(threadPoolSize);
        Semaphore semaphore = new Semaphore(12);

        for (int i = 0; i < threadPoolSize; i++) {
            executor.submit(new Task(semaphore, countDownLatch));
        }

        countDownLatch.await();
        System.out.println("所有线程执行完毕...");
    }


    @AllArgsConstructor
    class Task implements Runnable {

        private Semaphore semaphore;
        private CountDownLatch countDownLatch;

        @Override
        public void run() {

            try {
                semaphore.acquire(2);
                TimeUnit.SECONDS.sleep(new Random().nextInt(4));
                System.out.printf("[ %s ] 执行完成，剩余可用通路 %s 个...\n", Thread.currentThread().getName(), semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(2);
                countDownLatch.countDown();
            }
        }
    }

}
