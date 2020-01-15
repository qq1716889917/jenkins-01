package com.wzt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server01Start {
    public static void main(String[] args) {
        SpringApplication.run(Server01Start.class,args);
    }
}
