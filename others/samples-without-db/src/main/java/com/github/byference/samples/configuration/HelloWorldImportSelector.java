package com.github.byference.samples.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorldImportSelector
 *
 * @author byference
 * @since 2019-08-26
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MyConfiguration.class.getName()};
    }

}
