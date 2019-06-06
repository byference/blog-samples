package com.github.byference.juc;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * {@link CyclicBarrier} Test
 *
 * @author byference
 * @since 2019/06/06
 */
public class CyclicBarrierTest {


    @Test
    public void cyclicBarrierTest() throws Exception {

        int threadPoolSize = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            executor.submit(new Task(cyclicBarrier));
        }

        TimeUnit.SECONDS.sleep(6);
        System.out.println("所有线程执行完毕...");
    }


    @AllArgsConstructor
    class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        @Override
        public void run() {

            int random = new Random().nextInt(5);
            try {
                System.out.printf("==>[ %s ] 休眠 %s s\n", Thread.currentThread().getName(), random);
                TimeUnit.SECONDS.sleep(random);

                cyclicBarrier.await();
                System.out.printf("<==[ %s ] 休眠 %s s后 执行完成...\n", Thread.currentThread().getName(), random);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}