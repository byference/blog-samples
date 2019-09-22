package com.github.byference.samples.util;

import lombok.Data;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

/**
 * AsyncOutAppender
 *
 * @author byference
 * @since 2019-09-22
 */
@Plugin(name = "AsyncOutAppender", category = "core", elementType = "appender", printObject = true)
public class AsyncOutAppender extends AbstractAppender {

    private Config config;

    private AsyncOutAppender(Config config, Filter filter, Layout<? extends Serializable> layout) {
        super(config.name, filter, layout);
        this.config = config;
    }

    @Override
    public void append(LogEvent logEvent) {

        CompletableFuture.runAsync(() -> System.err.println(config.getPrefix() + logEvent.getMessage().getFormattedMessage()));
    }


    @PluginFactory
    public static synchronized AsyncOutAppender asyncOutAppender(
            @PluginAttribute("name") String name,
            @PluginAttribute("prefix") String prefix,
            @PluginElement("Filters") Filter filters) {

        Config config = new Config();
        config.setName(name);
        config.setPrefix(prefix);
        return new AsyncOutAppender(config, filters, null);
    }


    @Data
    private static class Config {

        private String name;

        private String prefix;
    }

}
