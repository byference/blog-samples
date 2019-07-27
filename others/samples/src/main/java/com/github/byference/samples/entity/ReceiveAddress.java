package com.github.byference.samples.entity;

import lombok.Data;

/**
 * 收货地址
 *
 * @author byference
 * @since 2019-07-27
 */
@Data
public class ReceiveAddress {

    /**
     * 默认收获地址
     */
    private String defaultAddress;

    /**
     * 收货地址1
     */
    private String address1;

    /**
     * 收货地址2
     */
    private String address2;

}
