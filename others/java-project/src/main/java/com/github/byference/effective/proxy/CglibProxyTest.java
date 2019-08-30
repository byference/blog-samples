package com.github.byference.effective.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * CglibProxyTest
 *
 * @author byference
 * @since 2019-08-30
 */
public class CglibProxyTest {


    @Test
    public void cglibProxyTest() {

        LogServiceInterceptor interceptor = new LogServiceInterceptor();
        DefaultHelloService defaultHelloService = interceptor.newProxyInstance(DefaultHelloService.class);

        defaultHelloService.sayHello();
    }


    @Test
    public void jdkProxyTest() throws Exception {

        Class<HelloService> helloServiceClass = HelloService.class;
        HelloService object = new DefaultHelloService();

        HelloService helloService = (HelloService) Proxy.newProxyInstance(helloServiceClass.getClassLoader(), new Class<?>[]{helloServiceClass}, ((proxy, method, args) -> {

            System.out.println("jdk 代理开始...");
            Object invoke = method.invoke(object, args);
            System.out.println("jdk 代理结束...");
            return invoke;
        }));

        helloService.sayHello();

    }

}
