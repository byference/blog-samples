package com.github.byference.extensions.registrar.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * TinyMapperFactoryBean
 * return the method name by default implementation
 *
 * @author byference
 * @since 2019-10-02
 */
@Slf4j
public class TinyMapperFactoryBean<T> implements FactoryBean<T> {


    private Class<?> interfaceClass;

    public TinyMapperFactoryBean() {
    }

    public TinyMapperFactoryBean(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (proxy, method, args) -> {

            if (method.getName().equals("toString")) {
                return interfaceClass.getSimpleName();
            }
            // 如果返回值为 String 则返回方法名称
            return "proxy: " + method.getName();
        });
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }
}
