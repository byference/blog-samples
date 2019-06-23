package com.github.byference.samples.annotation;

import java.lang.annotation.*;

/**
 * @author byference
 * @since 2019-06-23
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
}
