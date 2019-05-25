package com.github.byference.effective.callback;

import com.github.byference.common.function.ThrowableHandle;
import org.junit.Test;

import java.io.IOException;

/**
 * 频繁处理接口异常可以使用如下方式统一处理
 *
 * @author byference
 * @since 2019/04/27
 */
public class ExceptionCallbackTest {


    @Test
    public void callbackTest() {

        execute(ExceptionCallbackTest::getProperties);
    }


    /**
     * 异常处理
     * @param throwableHandle {@link ThrowableHandle}
     */
    private static void execute(ThrowableHandle throwableHandle) {

        try {
            throwableHandle.handle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getProperties() throws IOException {

        throw new IOException();
    }

}
