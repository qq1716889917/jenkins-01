package com.wzt;

import com.wzt.Zuulfilter.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulStart {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStart.class);
    }

    @Bean
    public Filter useZuulFilter(){
        return new Filter();
    }

}
