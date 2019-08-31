package com.github.byference.samples.service.impl;

import com.github.byference.samples.bean.event.UserRegisterEvent;
import com.github.byference.samples.entity.User;
import com.github.byference.samples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * User {@link Service} implementation
 *
 * @author byference
 * @since 2019-08-31
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public User register(User user) {

        eventPublisher.publishEvent(new UserRegisterEvent(this, user));
        return user;
    }

}
