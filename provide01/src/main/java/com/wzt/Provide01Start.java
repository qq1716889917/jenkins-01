package com.wzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provide01Start {
    public static void main(String[] args) {
        SpringApplication.run(Provide01Start.class,args);
    }
}
