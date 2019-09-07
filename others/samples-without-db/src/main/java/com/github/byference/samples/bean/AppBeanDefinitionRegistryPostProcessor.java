package com.github.byference.samples.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * AppBeanDefinitionRegistryPostProcessor
 *
 * @author byference
 * @since 2019-09-07
 */
@Slf4j
@Component
public class AppBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(BeanDefinitionTestBean.class)
                .addPropertyValue("beanName", "beanDefinitionTestBean");

        registry.registerBeanDefinition("beanDefinitionTestBean", builder.getBeanDefinition());
        log.info("==> registry beanDefinitionTestBean success...");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
