package com.github.byference.effective.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * LogServiceInterceptor
 *
 * @author byference
 * @since 2019-08-30
 */
public class LogServiceInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 代理开始...");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("cglib 代理结束...");


        return result;
    }


    @SuppressWarnings("unchecked")
    <T> T newProxyInstance(Class<T> clazz) {

        Enhancer enhancer = new Enhancer();

        // 设置被代理类
        enhancer.setSuperclass(clazz);

        // 回调
        enhancer.setCallback(this);

        // 生成代理对象
        return (T) enhancer.create();
    }

}
