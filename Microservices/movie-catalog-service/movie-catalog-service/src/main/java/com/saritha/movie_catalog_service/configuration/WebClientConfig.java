package com.saritha.movie_catalog_service.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    @Bean
   @LoadBalanced
    public WebClient.Builder webClientBuilder() {
//        HttpClient httpClient = HttpClient.create()
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
//                .responseTimeout(Duration.ofSeconds(5))
//                .doOnConnected(conn ->
//                        conn.addHandlerLast(new ReadTimeoutHandler(5, TimeUnit.SECONDS))
//                                .addHandlerLast(new WriteTimeoutHandler(5, TimeUnit.SECONDS))
//                );
//
//        return WebClient.builder()
//                .clientConnector(new ReactorClientHttpConnector(httpClient));
        return WebClient.builder();
    }
}