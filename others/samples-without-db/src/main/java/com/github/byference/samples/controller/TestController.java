package com.github.byference.samples.controller;

import com.github.byference.samples.annotation.AuthToken;
import com.github.byference.samples.entity.User;
import com.github.byference.samples.entity.UserVO;
import com.github.byference.samples.properties.DefaultProperties;
import com.github.byference.samples.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author byference
 * @since 2019-06-23
 */
@Slf4j
@RestController
@EnableConfigurationProperties(DefaultProperties.class)
public class TestController {


    @Autowired
    private EchoService echoService;

    @Autowired
    private DefaultProperties defaultProperties;

    @Value("${spring.mvc.date-format:yyyy-MM-dd}")
    private String formatter;


    /**
     * by {@link WebMvcAutoConfiguration.EnableWebMvcConfiguration#mvcConversionService}
     *
     * @param date {@link Date}
     */
    @PostMapping("/date/format")
    public String testDateFormat(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.format(date);
    }


    @PostMapping("/url/match")
    public boolean defaultProperties(String path) {

        AntPathMatcher pathMatcher = new AntPathMatcher();
        String[] strings = StringUtils.delimitedListToStringArray(defaultProperties.getNonVerifiableUrls(), ",");
        boolean match = false;
        for (String string : strings) {
            if (match = pathMatcher.match(string, path)) {
                break;
            }
        }
        return match;
    }


    @PostMapping("/cardNumberValid")
    public UserVO cardNumberValid(@Valid UserVO userVO) {

        log.info("userVO: {}", userVO);
        return userVO;
    }


    /**
     * {@link RequestMapping#consumes} -> {@code Content-Type}
     * {@link RequestMapping#produces} -> {@code Accept}
     */
    @RequestMapping(value = "/user/message/converter",
            consumes = "application/properties+user",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User userMessageConverter(@RequestBody User user) {
        return user;
    }


    @RequestMapping("/echo")
    public String echo(String message, @AuthToken String token, HttpServletRequest request) {

        String userId = request.getHeader("userId");
        log.info("userId: {}", userId);
        return echoService.echo(message);
    }

}
