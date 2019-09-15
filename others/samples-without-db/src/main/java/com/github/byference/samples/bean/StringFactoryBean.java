package com.github.byference.samples.bean;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * StringFactoryBean
 *
 * @author byference
 * @since 2019-09-15
 */
public class StringFactoryBean<T> implements FactoryBean<T> {


    private Class<?> interfaceClass;

    public StringFactoryBean() {
    }

    public StringFactoryBean(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getObject() throws Exception {

        if (interfaceClass != null) {
            return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, (proxy, method, arg) -> {

                if (method.getName().equals("toString")) {
                    return interfaceClass.getSimpleName();
                }
                return String.format("[%s]: print", interfaceClass.getSimpleName());
            });
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
