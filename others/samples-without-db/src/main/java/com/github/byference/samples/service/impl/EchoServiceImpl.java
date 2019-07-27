package com.github.byference.samples.service.impl;

import com.github.byference.samples.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * DefaultEchoService
 *
 * @author byference
 * @since 2019-07-20
 */
@Slf4j
@Component
public class EchoServiceImpl implements EchoService {


    @Override
    public String echo(String message) {

        log.info("[Thread-{}]", Thread.currentThread().getName());
        return "Echo: " + message;
    }

}
