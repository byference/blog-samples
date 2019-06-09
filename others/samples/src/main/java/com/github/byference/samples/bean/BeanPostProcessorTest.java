package com.github.byference.samples.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * BeanPostProcessor Test
 *
 * @author byference
 * @since 2019/06/09
 */
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {


    private static final String TARGET_BEAN_NAME = "initializationBeans";


    /**
     * 在所有的bean的 {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet} 方法之前执行
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(TARGET_BEAN_NAME, beanName)) {
            System.out.printf("BeanPostProcessorTest#postProcessBeforeInitialization: %s\n", beanName);
        }
        // 如果返回null，后续的BeanPostProcessor不会被执行
        return bean;
    }


    /**
     * 在所有的bean的 {@link org.springframework.beans.factory.InitializingBean#afterPropertiesSet} 方法之后执行的
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(TARGET_BEAN_NAME, beanName)) {
            System.out.printf("BeanPostProcessorTest#postProcessAfterInitialization: %s\n", beanName);
        }
        // 如果返回null，后续的BeanPostProcessor不会被执行
        return bean;
    }

}
