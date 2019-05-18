package com.github.byference.juc.async;

import com.github.byference.common.ThrowableHandle;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.BiFunction;

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
     * 测试 {@link CompletableFuture#thenCombine(CompletionStage, BiFunction)}
     * @see CompletableFuture
     */
    @Test
    public void completableFutureCombination2Test() {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureTest::getThreadName, executor);
        // 完成事件
        future1.thenAccept(message -> System.out.printf("[%s] future1 执行完成, result: [ %s ]\n", Thread.currentThread().getName(), message));

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(CompletableFutureTest::getMessage, executor);
        future2.thenAccept(message -> System.out.printf("[%s] future2 执行完成, result: [ %s ]\n", Thread.currentThread().getName(), message));

        // 组合
        CompletableFuture<String> future3 = future1.thenCombine(future2, (f1, f2) -> String.format("[%s]: %s", f1, f2));

        // get
        execute(() -> {
            long startTime = System.currentTimeMillis();
            String message = future3.get();
            long endTime = System.currentTimeMillis();
            System.out.printf("%s , 耗时: %s s\n", message, (endTime - startTime) / 1000);
        });
    }


    /**
     * 测试 {@link CompletableFuture#thenCombine(CompletionStage, BiFunction)}
     * @see CompletableFuture
     */
    @Test
    public void completableFutureCombinationTest() {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureTest::getThreadName, executor);
        CompletableFuture<String> future2 = future1.thenCombine(
                CompletableFuture.supplyAsync(CompletableFutureTest::getMessage, executor),
                (f1, f2) -> String.format("Thread: [ %s ]: %s", f1, f2));

        // get
        execute(() -> {
            long startTime = System.currentTimeMillis();
            String message = future2.get();
            long endTime = System.currentTimeMillis();

            System.out.printf("%s , 耗时: %s s\n", message, (endTime - startTime) / 1000);
        });
    }


    /**
     * 测试 {@link CompletableFuture}
     * @see CompletableFuture
     */
    @Test
    public void completableFutureTest() {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(CompletableFutureTest::getMessage, executor);
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
     * 休眠3s后返回当前线程名称
     * @return current {@link Thread#getName}
     */
    private static String getThreadName() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
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
