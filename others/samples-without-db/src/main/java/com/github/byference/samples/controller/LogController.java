package com.github.byference.samples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * LogController
 *
 * @author byference
 * @since 2019-09-22
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LogController {


    @GetMapping("info")
    public String info() {

        log.info("LogController.info print: {}", LocalDateTime.now());
//        for (int i = 0; i < 500; i++) {
//            log.info("LogController.info print: {}", LocalDateTime.now());
//        }
        return "log info success";
    }


    @GetMapping("error")
    public String error() {

        for (int i = 0; i < 500; i++) {
            log.error("LogController.info print: {}", LocalDateTime.now());
        }
        return "log error success";
    }

}
