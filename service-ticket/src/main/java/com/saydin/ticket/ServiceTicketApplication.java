package com.saydin.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "com.saydin.ticket.api",
        "com.saydin.ticket.config",
        "com.saydin.ticket.entity",
        "com.saydin.ticket.repo",
        "com.saydin.ticket.service",
})
public class ServiceTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTicketApplication.class,args);
    }
}
