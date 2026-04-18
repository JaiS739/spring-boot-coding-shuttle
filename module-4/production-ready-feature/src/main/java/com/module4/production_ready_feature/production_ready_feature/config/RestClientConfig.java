package com.module4.production_ready_feature.production_ready_feature.config;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


@Configuration
public class RestClientConfig {

    @Value("${employeeService.base.url}")
    private String baseURL;

    @Bean
    @Qualifier("employeeRestClient")
    public RestClient getEmployeeServiceRestClient(){
        return RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(baseURL)
                .build();
    }

}
