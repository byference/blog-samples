package com.github.byference.samples.bean.event;

import com.github.byference.samples.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * UserRegisterListener
 *
 * @see ApplicationListener
 * @author byference
 * @since 2019-08-31
 */
@Component
public class UserRegisterListener {


    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {

        User user = event.getUser();

        System.out.printf("==> 新用户注册： [%s] \n", user.getUserName());
    }

}
