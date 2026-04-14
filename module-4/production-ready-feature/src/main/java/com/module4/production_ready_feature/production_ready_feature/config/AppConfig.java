package com.module4.production_ready_feature.production_ready_feature.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper () {
        return new ModelMapper();
    }
}
