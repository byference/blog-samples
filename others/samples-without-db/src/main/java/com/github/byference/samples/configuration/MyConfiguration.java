package com.github.byference.samples.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfiguration
 *
 * @author byference
 * @since 2019-08-26
 */
@Configuration
public class MyConfiguration {


    @Bean
    public String importSelectorTest() {
        return "ImportSelector Test...";
    }

}
