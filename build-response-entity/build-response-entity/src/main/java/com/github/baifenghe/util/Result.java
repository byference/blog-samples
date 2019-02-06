package com.github.baifenghe.util;

import lombok.Builder;

/**
 * @author bfh
 * @since 2019/02/06
 */
@Builder
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

}
