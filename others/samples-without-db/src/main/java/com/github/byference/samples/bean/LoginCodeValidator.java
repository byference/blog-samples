package com.github.byference.samples.bean;

import com.github.byference.samples.annotation.ValidCardNumber;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link ValidCardNumber} {@link ConstraintValidator} 实现
 *
 * @author byference
 * @since 2019-07-12
 */
public class LoginCodeValidator implements ConstraintValidator<ValidCardNumber, String> {


    @Override
    public void initialize(ValidCardNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 必须是T开头
        return StringUtils.startsWithIgnoreCase(value, "T");
    }
}
