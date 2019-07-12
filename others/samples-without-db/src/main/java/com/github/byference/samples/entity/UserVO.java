package com.github.byference.samples.entity;

import com.github.byference.samples.annotation.ValidCardNumber;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 系统用户
 *
 * @author byference
 * @since 2019-07-12
 */
@Data
public class UserVO {

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    @Min(value = 0, message = "用户id必须大于零")
    private Integer id;

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 卡号
     */
    @ValidCardNumber(message = "卡号必须以T开头")
    private String cardNumber;
}
