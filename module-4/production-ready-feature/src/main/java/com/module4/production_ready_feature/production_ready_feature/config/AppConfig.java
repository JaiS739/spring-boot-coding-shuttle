package com.module4.production_ready_feature.production_ready_feature.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper () {
        return new ModelMapper();
    }
}
