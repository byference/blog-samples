package com.github.byference.samples.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 账户
 *
 * @author byference
 * @since 2019/05/11
 */
@Data
@ToString
public class Account {

    /**
     * 用户id
     */
    private int id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 待扣除金额
     */
    private BigDecimal account;

}
