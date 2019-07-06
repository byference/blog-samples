package com.github.byference.samples.bean;

import com.github.byference.samples.common.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Objects;

/**
 * WebFilter
 *
 * @author byference
 * @since 2019-07-06
 */
@Slf4j
@Component
public class WebFilter implements Filter {


    /**
     * 从header中取出token解密后放入header中，然后通过 {@link HttpServletRequest#getHeader(String)} 获取
     * 不兼容 {@link RequestHeader}
     *
     * @see HttpServletRequestWrapper#getHeader(String)
     * @see HttpServletRequestWrapper#getParameterValues(String)
     * @see HttpServletRequestWrapper#getParameterNames()
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取header中的token
        String authorization = request.getHeader("Authorization");
        // 模拟对token解密
        log.info("解密token");
        String token = authorization + "--";

        // 包装请求
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request) {
            @Override
            public String getHeader(String name) {
                if (Objects.equals(SystemConstant.CURRENT_USER_ID, name)) {
                    return token;
                }
                return super.getHeader(name);
            }
        };
        filterChain.doFilter(requestWrapper, servletResponse);
    }

}