package com.github.byference.common;

/**
 * {@link Throwable} Handle
 *
 * @author byference
 * @since 2019/05/04
 */
@FunctionalInterface
public interface ThrowableHandle {

    /**
     * 统一异常处理接口
     * @throws Exception 待处理 {@link Exception}
     */
    void handle() throws Exception;
}
