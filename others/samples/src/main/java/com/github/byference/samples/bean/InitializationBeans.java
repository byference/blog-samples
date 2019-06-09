package com.github.byference.samples.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author byference
 * @since 2019/03/30
 */
@Component
public class InitializationBeans {

    @Value("${byference.application.name}")
    private String name;

    @Value("${byference.application.version:1.0.0}")
    private String version;


    @Bean
    public CommandLineRunner initDemo() {
        return args -> System.out.printf("CommandLineRunner [ name: %s, version: %s ]", name, version);
    }


    @Bean
    public ApplicationRunner initDemo1() {
        return args -> System.out.println("ApplicationRunner");
    }

    /**
     * 构造方法 -> @Autowired -> @PostConstruct
     * @see PostConstruct
     */
    @PostConstruct
    public void init() {
        System.out.printf("PostConstruct [ name: %s, version: %s ]\n", name, version);
    }

}
