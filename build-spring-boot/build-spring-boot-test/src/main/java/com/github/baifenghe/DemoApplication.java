package com.github.baifenghe;

import com.github.baifenghe.annotation.EnableStringService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bfh
 * @since 2019/01/16
 */
@SpringBootApplication
@EnableStringService
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

