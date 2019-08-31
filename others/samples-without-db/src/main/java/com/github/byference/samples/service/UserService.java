package com.github.byference.samples.service;

import com.github.byference.samples.entity.User;

/**
 * UserService
 *
 * @author byference
 * @since 2019-08-31
 */
public interface UserService {

    /**
     * User register
     * @param user {@link User}
     * @return created user if success, or else null
     */
    User register(User user);

}
