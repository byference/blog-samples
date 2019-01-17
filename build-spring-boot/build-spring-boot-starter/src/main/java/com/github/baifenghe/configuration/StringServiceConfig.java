package com.github.baifenghe.configuration;

import com.github.baifenghe.demo.StringService;
import org.springframework.context.annotation.Bean;

/**
 * @author bfh
 * @since 2019/01/16
 */
public class StringServiceConfig {

    @Bean
    StringService stringService() {
        return new StringService();
    }

}
