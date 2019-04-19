package com.github.byference.samples.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author byference
 * @since 2019/03/30
 */
@Component
public class InitializationBeans {


    @Bean
    public CommandLineRunner initDemo() {
        return args -> {
            System.out.println("initDemo start");
            System.out.println("--> " + Arrays.toString(args));
        };
    }

}
