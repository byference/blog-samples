package com.github.baifenghe.annotation;

import com.github.baifenghe.configuration.StringServiceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author bfh
 * @since 2019/01/16
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({StringServiceConfig.class})
public @interface EnableStringService {
}
