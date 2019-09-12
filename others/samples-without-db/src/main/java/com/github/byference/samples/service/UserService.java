package com.github.byference.samples.service;

import com.github.byference.samples.bean.event.UserRegisterEvent;
import com.github.byference.samples.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * UserService
 *
 * @author byference
 * @since 2019-08-31
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;


    /**
     * User register
     *
     * @param user {@link User}
     * @return created user if successful, or else null
     */
    public User register(User user) {

        eventPublisher.publishEvent(new UserRegisterEvent(this, user));
        return user;
    }


    /**
     * retry send message
     */
    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public void retrySendMessage(String message) {

        log.info("[{}] - {} :start send message...", Thread.currentThread().getName(), LocalDateTime.now());

        if (StringUtils.isEmpty(message)) {
            throw new IllegalArgumentException("Send message is not allowed to be empty");
        }

        log.info("[{}] - {} :send message success...", Thread.currentThread().getName(), LocalDateTime.now());
    }

}
