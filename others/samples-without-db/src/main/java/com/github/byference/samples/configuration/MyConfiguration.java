package com.github.byference.samples.configuration;

import com.github.byference.samples.condition.ConditionalOnNotWindows10;
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


    @ConditionalOnNotWindows10
    @Bean
    public String importSelectorTest() {
        return "helloWorld";
    }

}
