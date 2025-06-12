package com.saritha.movie_catalog_service.service;

import com.saritha.movie_catalog_service.entity.Rating;
import com.saritha.movie_catalog_service.entity.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserRatingService {

    @Autowired
    private  WebClient.Builder webClientBuilder;

    @CircuitBreaker(name = "movieRatingCB", fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://movie-Rating-service/ratingsdata/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
    }


    public UserRating getFallbackUserRating(String userId, Throwable t) {
        UserRating userRating = new UserRating();
        userRating.setRatings(List.of(new Rating("0", 0)));
        return  userRating;
    }

}
