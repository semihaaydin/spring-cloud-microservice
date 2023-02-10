package com.saydin.ticket.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.saydin.ticket.repo")
public class CustomBeanFactory {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
