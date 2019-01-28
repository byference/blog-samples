package com.github.baifenghe.properties;

import com.github.baifenghe.bean.YamlPropertyLoaderFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author bfh
 * @since 2019/01/28
 */
@Data
@Component
@PropertySource(value = "classpath:common.yml", factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix = "common")
public class CommonProperties {

    private String name = "common";

    private Set<String> list = new LinkedHashSet<>();
}
