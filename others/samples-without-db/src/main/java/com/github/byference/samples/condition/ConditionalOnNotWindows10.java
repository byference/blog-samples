package com.github.byference.samples.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * ConditionalOnWindows10
 *
 * @author byference
 * @since 2019-08-26
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnNotWindows10Conditional.class)
public @interface ConditionalOnNotWindows10 {
}
