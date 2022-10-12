package com.hadicha.zeonshop.jwt;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
