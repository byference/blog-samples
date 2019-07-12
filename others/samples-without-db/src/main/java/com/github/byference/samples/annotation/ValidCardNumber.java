package com.github.byference.samples.annotation;

import com.github.byference.samples.bean.LoginCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 卡号校验:
 * 必须是T开头
 *
 * @author byference
 * @since 2019-07-12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = LoginCodeValidator.class)
public @interface ValidCardNumber {

    String message() default "{ValidCardNumber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
