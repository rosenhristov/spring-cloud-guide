package com.rosenhristov.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author Rosen Hristov
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate rest() {
        return new RestTemplateBuilder().build();
    }

}