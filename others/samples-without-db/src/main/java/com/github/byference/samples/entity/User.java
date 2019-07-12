package com.github.byference.samples.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 系统用户实体类
 *
 * @author byference
 * @since 2019-07-07
 */
@Builder
@Data
public class User {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;
}
