package com.github.byference.samples.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * default properties
 *
 * @author byference
 * @since 2019-07-30
 */
@Data
@ConfigurationProperties("samples")
public class DefaultProperties {


    /**
     * samples name
     */
    private String name;


    /**
     * Non-verifiable urls
     */
    private String nonVerifiableUrls;

}
