package com.github.baifenghe.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author bfh
 * @since 2019/01/27
 */
@Data
@Component
@ConfigurationProperties(prefix = "bfh")
public class DemoProperties {

    /**
     * bfh name.
     */
    private String name = "bfh";

    /**
     * bfh ip list.
     */
    private Set<String> ips = new LinkedHashSet<>();
}
