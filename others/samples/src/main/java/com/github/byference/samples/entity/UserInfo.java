package com.github.byference.samples.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byference
 * @since 2019/07/27
 */
@Data
public class UserInfo implements Serializable {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户等级
     */
    private Integer userLevel;

    /**
     * 收获地址
     */
    private ReceiveAddress receiveAddress;
}