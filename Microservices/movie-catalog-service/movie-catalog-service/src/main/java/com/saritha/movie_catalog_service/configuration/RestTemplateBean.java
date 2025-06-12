package com.saritha.movie_catalog_service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {

            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setConnectTimeout(3000); // 3 seconds
            factory.setReadTimeout(3000);    // 3 seconds
            return new RestTemplate(factory);
       // return new RestTemplate();
    }
}