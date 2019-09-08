package com.github.byference.samples;

import com.github.byference.samples.configuration.HelloWorldImportSelector;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author bfh
 * @since 2019/06/23
 */
@EnableRetry
@Import(HelloWorldImportSelector.class)
@SpringBootApplication
public class SamplesWithoutDbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SamplesWithoutDbApplication.class, args);


        try {
            String helloWorld = context.getBean("importSelectorTest", String.class);
            System.out.println("importSelectorTest: " + helloWorld);
        } catch (BeansException e) {
            System.out.println("importSelectorTest is null");
        }

    }

}

