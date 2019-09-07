package com.github.byference.samples.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * AppBeanPostProcessor
 *
 * @author byference
 * @since 2019-09-07
 */
@Component
public class AppBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (Objects.equals("extApplicationName", beanName)) {

            System.out.println("start change extApplicationName...");
            return "modified extApplicationName";
        }
        return bean;
    }

}
