package com.github.baifenghe.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfiguration
 *
 * @author bfh
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = "demo", name = "enable", havingValue = "true")
public class MyConfiguration {


    @Bean
    public void println() {
        System.out.println("-->  hello world\n");
    }


}
