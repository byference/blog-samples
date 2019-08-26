package com.github.byference.samples.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Locale;
import java.util.Objects;

/**
 * OnWindows10Conditional
 *
 * @author byference
 * @since 2019-08-26
 */
public class OnNotWindows10Conditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String osVersion = System.getProperty("os.name").toLowerCase(Locale.US);
        return !Objects.equals("windows 10", osVersion);
    }

}
