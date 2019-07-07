package com.github.byference.samples.controller;

import com.github.byference.samples.annotation.AuthToken;
import com.github.byference.samples.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * {@link RequestMapping#consumes} -> {@code Content-Type}
     * {@link RequestMapping#produces} -> {@code Accept}
     */
    @RequestMapping(value = "/user/message/converter",
            consumes = "application/properties+user",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User userMessageConverter(@RequestBody User user) {
        return user;
    }


    @RequestMapping("/echo")
    public String echo(String message, @AuthToken String token, HttpServletRequest request) {

        String userId = request.getHeader("userId");
        log.info("userId: {}", userId);
        return String.format("Echo: %s, Token: %s", message, token);
    }

}
