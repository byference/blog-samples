package com.github.byference.samples.configuration;

import com.github.byference.samples.bean.BeanDefinitionTestBean;
import com.github.byference.samples.condition.ConditionalOnNotWindows10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * MyConfiguration
 *
 * @author byference
 * @since 2019-08-26
 */
@Configuration
public class MyConfiguration {

    @Autowired
    @Qualifier("extApplicationName")
    private String extApplicationName;

    @Resource(name = "beanDefinitionTestBean")
    private BeanDefinitionTestBean beanDefinitionTestBean;


    @ConditionalOnNotWindows10
    @Bean
    public String importSelectorTest() {
        return "helloWorld";
    }


    @Bean
    public String extApplicationName() {
        return "original extApplicationName";
    }


    @Bean
    public ApplicationRunner init() {

        return args -> {
            System.err.println("extApplicationName init: " + extApplicationName);
            System.err.println("beanDefinitionTestBean init: " + beanDefinitionTestBean);
        };
    }
}
