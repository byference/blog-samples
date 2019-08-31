package com.github.byference.samples.bean.event;

import com.github.byference.samples.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * UserRegisterEvent
 *
 * @author byference
 * @since 2019-08-31
 */
public class UserRegisterEvent extends ApplicationEvent {


    private final User user;


    /**
     * Create a new ApplicationEvent.
     */
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }


    public User getUser() {
        return user;
    }

}
