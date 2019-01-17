package com.github.baifenghe.configuration;

import com.github.baifenghe.demo.IntegerService;
import org.springframework.context.annotation.Bean;

/**
 * @author bfh
 * @since 2019/01/16
 */
public class IntegerServiceConfig {

    @Bean
    IntegerService integerService() {
        return new IntegerService();
    }

}
