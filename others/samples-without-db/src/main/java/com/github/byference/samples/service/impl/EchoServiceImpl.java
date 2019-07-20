package com.github.byference.samples.service.impl;

import com.github.byference.samples.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * DefaultEchoService
 *
 * @author byference
 * @since 2019-07-20
 */
@Component
public class EchoServiceImpl implements EchoService {


    @Override
    public String echo(String message) {
        return "Echo: " + message;
    }

}
