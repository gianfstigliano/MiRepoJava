package com.hiberus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApplicationPizzaWrite {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPizzaWrite.class,args);
    }
}