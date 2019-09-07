package com.github.byference.samples.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * AppPropertySource
 *
 * @author byference
 * @since 2019-09-01
 */
@Configuration
@PropertySource("default-app.properties")
public class AppPropertySource {

    @Autowired
    private Environment environment;

    @Value("${web.name}")
    private String name;



    @PostConstruct
    public void printWebName() {

        System.err.println("web name is " + name);
        System.err.println("web host is " + environment.getProperty("web.host"));
    }


}
