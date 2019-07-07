package com.github.byference.samples.configuration;

import com.github.byference.samples.entity.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link User} 自描述消息处理
 *
 * @author byference
 * @since 2019-07-07
 */
public class PropertiesUserHttpMessageConverter extends AbstractHttpMessageConverter<User> {


    public PropertiesUserHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+user"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        InputStreamReader reader = new InputStreamReader(inputMessage.getBody(), getDefaultCharset());
        Properties properties = new Properties();
        properties.load(reader);
        return User.builder().id(Integer.valueOf(properties.getProperty("user.id"))).userName(properties.getProperty("user.userName")).build();
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        Properties properties = new Properties();
        properties.setProperty("user.id", String.valueOf(user.getId()));
        properties.setProperty("user.userName", user.getUserName());
        properties.store(outputMessage.getBody(), "PropertiesUserHttpMessageConverter");
    }

}
