package com.github.byference.samples.bean;

import com.github.byference.samples.service.EchoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * HttpInvokerConfiguration
 *
 * @author byference
 * @since 2019-07-20
 */
@Configuration
public class HttpInvokerConfiguration {

    @Value("${server.port}")
    private String port;


    @Bean("/echoService")
    public HttpInvokerServiceExporter echoServiceExporter(EchoService echoService) {

        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(echoService);
        exporter.setServiceInterface(EchoService.class);
        return exporter;
    }


//    /**
//     * 需要另起一个项目去注入如下 {@link Bean} , 然后从获取 {@link EchoService} 接口调用
//     * <code>
//     * EchoService echoService = applicationContext.getBean(EchoService.class);
//     * String echo = echoService.echo("joy");
//     * </code>
//     *
//     * @return
//     */
//    @Bean("/echoServiceProxy")
//    public HttpInvokerProxyFactoryBean echoServiceProxy() {
//
//        HttpInvokerProxyFactoryBean factoryBean = new HttpInvokerProxyFactoryBean();
//        factoryBean.setServiceInterface(EchoService.class);
//        factoryBean.setServiceUrl("http://localhost:" + port + "/echoService");
//        return factoryBean;
//    }

}
