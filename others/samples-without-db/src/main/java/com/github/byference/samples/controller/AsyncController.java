package com.github.byference.samples.controller;

import com.github.byference.samples.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * AsyncController
 *
 * @author byference
 * @since 2019-09-12
 */
@Slf4j
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;


    @RequestMapping("runAsyncWithRequest")
    public void runAsyncWithRequest() {

        asyncService.runAsyncWithRequest();
        log.info("runAsync with request has returned...");
    }


    @RequestMapping("supplyAsync")
    public String supplyAsync() throws Exception {

        Future<String> asyncResult = asyncService.supplyAsync();
        log.info("supply async has returned...");
        return asyncResult.get(3, TimeUnit.SECONDS);
    }


    @RequestMapping("runAsync")
    public void runAsync() {

        asyncService.runAsync();
        log.info("run async has returned...");
    }


    @RequestMapping("runAsyncByThreadPool")
    public void runAsyncByThreadPool() {

        asyncService.runAsyncByThreadPool();
        log.info("run async by thread pool has returned...");
    }

}
