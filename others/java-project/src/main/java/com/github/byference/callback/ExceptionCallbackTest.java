package com.github.byference.callback;

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
     * 异常处理接口
     */
    interface TestCallback {

        void callback() throws IOException;
    }


    /**
     * 异常处理
     * @param testCallback {@link TestCallback}
     */
    private static void execute(TestCallback testCallback) {

        try {
            testCallback.callback();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void getProperties() throws IOException {

        throw new IOException();
    }

}
