package com.github.byference.effective.proxy;

/**
 * DefaultHelloService
 *
 * @author byference
 * @since 2019-08-30
 */
public class DefaultHelloService implements HelloService {


    @Override
    public void sayHello() {
        System.out.println("hello...");
    }

}
