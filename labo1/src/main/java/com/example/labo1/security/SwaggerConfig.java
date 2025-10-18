package com.example.labo1.security;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi mainApi() {
        return GroupedOpenApi.builder()
                .group("default")
                // ✅ only scan your own controllers
                .packagesToScan("com.example.labo1.controller")
                // optionally skip problematic endpoints
                .pathsToExclude("/profile/**", "/actuator/**")
                .build();
    }
}
