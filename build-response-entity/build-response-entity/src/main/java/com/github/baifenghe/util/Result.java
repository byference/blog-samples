package com.github.baifenghe.util;

import lombok.Builder;
import lombok.Data;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
@Data
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
