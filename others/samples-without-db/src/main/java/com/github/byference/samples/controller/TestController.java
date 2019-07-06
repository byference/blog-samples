package com.github.byference.samples.controller;

import com.github.byference.samples.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author byference
 * @since 2019-06-23
 */
@Slf4j
@RestController
public class TestController {



    @RequestMapping("/echo")
    public String echo(String message, @AuthToken String token, HttpServletRequest request) {

        String userId = request.getHeader("userId");
        log.info("userId: {}", userId);
        return String.format("Echo: %s, Token: %s", message, token);
    }

}
