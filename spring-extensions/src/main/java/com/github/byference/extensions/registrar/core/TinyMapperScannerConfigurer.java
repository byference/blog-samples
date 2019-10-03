package com.github.byference.extensions.registrar.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * TinyMapperScannerConfigurer
 *
 * @author byference
 * @since 2019-10-02
 */
@Component
public class TinyMapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        TinyMapperScanner scanner = new TinyMapperScanner(registry);
        scanner.setAnnotationClass(null);
        scanner.registerFilters();
        scanner.doScan("com.github.byference.extensions.registrar.mapper");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
