package com.github.byference.samples.configuration;

import com.github.byference.samples.bean.BeanDefinitionTestBean;
import com.github.byference.samples.bean.UserMapper;
import com.github.byference.samples.condition.ConditionalOnNotWindows10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * MyConfiguration
 *
 * @author byference
 * @since 2019-08-26
 */
@Configuration
public class MyConfiguration {

    @Autowired
    @Qualifier("extApplicationName")
    private String extApplicationName;

    @Resource(name = "beanDefinitionTestBean")
    private BeanDefinitionTestBean beanDefinitionTestBean;

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    /**
     * @see TaskExecutionAutoConfiguration#taskExecutorBuilder()
     * @return {@link Executor}
     */
    @Bean
    public Executor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setQueueCapacity(100);
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("task-executor-");

        executor.setTaskDecorator(runnable -> {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            return () -> {
                try {
                    RequestContextHolder.setRequestAttributes(requestAttributes);
                    runnable.run();
                } finally {
                    RequestContextHolder.resetRequestAttributes();
                }
            };
        });
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }


    @ConditionalOnNotWindows10
    @Bean
    public String importSelectorTest() {
        return "helloWorld";
    }


    @Bean
    public String extApplicationName() {
        return "original extApplicationName";
    }


    @Bean
    public ApplicationRunner init() {

        return args -> {
            System.err.println("extApplicationName init: " + extApplicationName);
            System.err.println("beanDefinitionTestBean init: " + beanDefinitionTestBean);
            System.err.println("userMapper init: " + userMapper.print());
        };
    }
}
