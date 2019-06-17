package com.github.byference.effective.normal;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author byference
 * @since 2019/06/17
 */
public class ThreadLocalTest {

    private static ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(
            ()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    private static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);


    @Test
    public void integerThreadLocal() throws InterruptedException {

        int threadPoolSize = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                count.set(count.get() + 1);
                System.out.printf("[%s] - [%d]\n", Thread.currentThread().getName(), count.get());
            });
        }
        TimeUnit.SECONDS.sleep(1);
    }


    @Test
    public void dateFormatThreadLocal() throws InterruptedException {

        int threadPoolSize = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize * 2; i++) {
            executorService.execute(() -> System.out.println(dateFormat.get().format(new Date())));
        }
        TimeUnit.SECONDS.sleep(2);
    }

}
