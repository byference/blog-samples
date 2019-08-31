package com.github.byference.samples.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统用户实体类
 *
 * @author byference
 * @since 2019-07-07
 */
@AllArgsConstructor
@NoArgsConstructor
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
