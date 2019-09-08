package com.github.byference.samples.controller;

import com.github.byference.samples.entity.User;
import com.github.byference.samples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}.
 *
 * @author byference
 * @since 2019-08-31
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("sendMessage")
    @ResponseBody
    public void retrySendMessage(String message) {

        log.info("Thread - [{}]", Thread.currentThread().getName());
        userService.retrySendMessage(message);
    }


    @RequestMapping("register")
    @ResponseBody
    public User register(User user) {

        System.out.println("register start...");
        return userService.register(user);
    }


}
