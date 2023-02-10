package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicesNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesNotificationApplication.class,args);
    }
}
