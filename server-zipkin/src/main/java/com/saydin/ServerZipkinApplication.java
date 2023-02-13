package com.saydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerZipkinApplication.class,args);
    }
}
