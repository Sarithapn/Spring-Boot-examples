package com.saritha.movie_catalog_service.service;



import com.saritha.movie_catalog_service.entity.Rating;
import com.saritha.movie_catalog_service.entity.UserRating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRatingServiceRest {

    @Autowired
    public RestTemplate restTemplate;

    @CircuitBreaker(name = "movieRatingCBRest", fallbackMethod = "getFallbackUserRatingRest")
    public UserRating getUserRating(String userId) {
     //   try {
        return restTemplate.getForObject(
                "http://movie-Rating-service/ratingsdata/users/" + userId,
                UserRating.class
        );
//    } catch (Exception ex) {
//            System.out.println("Exception occurred while fetching user rating: " + ex.getMessage());
//        return getFallbackUserRatingRest(userId, ex);
//    }
    }
    public UserRating getFallbackUserRatingRest(String userId, Throwable t) {
        UserRating userRating = new UserRating();
        userRating.setRatings(List.of(new Rating("100", 0)));
        return userRating;
    }
}
