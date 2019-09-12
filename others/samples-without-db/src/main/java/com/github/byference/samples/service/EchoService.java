package com.github.byference.samples.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * EchoService
 *
 * @author byference
 * @since 2019-07-20
 */
@Slf4j
@Component
public class EchoService {


    public String echo(String message) {

        log.info("[Thread-{}]", Thread.currentThread().getName());
        return "Echo: " + message;
    }
}
