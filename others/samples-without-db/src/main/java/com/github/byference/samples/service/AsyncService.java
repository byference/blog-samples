package com.github.byference.samples.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * AsyncService
 *
 * @author byference
 * @since 2019-09-12
 */
@Slf4j
@Service
public class AsyncService {

    /**
     * 异步执行：无返回值
     */
    @Async
    public void runAsyncWithRequest() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {

            HttpServletRequest request = requestAttributes.getRequest();
            log.info("[{}] - runAsyncWithRequest end at {}.", Thread.currentThread().getName(), LocalDateTime.now());
            log.info("==> {}: {}", request.getMethod().toUpperCase(), request.getRequestURI());
        } else {
            log.info("request is null");
        }
    }


    /**
     * 异步执行：有返回值
     */
    @Async
    public Future<String> supplyAsync() {

        String result = "fail";
        try {
            // sleep 2 seconds
            TimeUnit.SECONDS.sleep(2);
            log.info("[{}] - supplyAsync end at {}.", Thread.currentThread().getName(), LocalDateTime.now());
            result = "hello world...";

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(result);
    }


    /**
     * 异步执行：无返回值
     */
    @Async
    public void runAsync() {

        try {
            // sleep 2 seconds
            TimeUnit.SECONDS.sleep(2);
            log.info("[{}] - runAsync end at {}.", Thread.currentThread().getName(), LocalDateTime.now());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 异步执行：无返回值
     */
    public void runAsyncByThreadPool() {

        CompletableFuture.runAsync(() -> {
            try {
                // sleep 2 seconds
                TimeUnit.SECONDS.sleep(2);
                log.info("[{}] - runAsyncByThreadPool end at {}.", Thread.currentThread().getName(), LocalDateTime.now());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }



    /**
     * log execute status
     */
    public void info() {
        log.info("[{}] - runAsync end at {}.", Thread.currentThread().getName(), LocalDateTime.now());
    }


    /**
     * log execute message
     *
     * @param message execute message
     */
    public void info(String message) {
        log.info("[{}] - runAsync end at {}, message is {}.", Thread.currentThread().getName(), LocalDateTime.now(), message);
    }

}
