package com.wzt;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Userman03Start {
    public static void main(String[] args) {
        SpringApplication.run(Userman03Start.class,args);
    }

    /*@Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(250);
        factory.setConnectionRequestTimeout(250);
        return new RestTemplate(factory);
    }*/

    @Bean
    public ServletRegistrationBean createServletRegistrationBean(){
        /*创建熔断监控器的servlet*/
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        /*创建servlet管理器*/
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet);
        /*设置servlet的访问路径*/
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        /*设置servlet启动顺序*/
        servletRegistrationBean.setLoadOnStartup(1);
        /*设置servlet的名字*/
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");

        return servletRegistrationBean;
    }

}
