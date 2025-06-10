package com.saritha.movie_Rating_service.controller;

import com.saritha.movie_Rating_service.entity.Rating;
import com.saritha.movie_Rating_service.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRatingController {

    @GetMapping("/ratingsdata/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        // In a real application, you would fetch the rating from a database or another service.
        // Here, we are returning a hardcoded value for demonstration purposes.
        return new Rating(movieId, 4.5f);
    }

    @GetMapping("/ratingsdata/users/{userId}")
    public UserRating getuserRating(@PathVariable String userId) {
        List<Rating> rating = List.of(
                new Rating("1", 4.5f),
                new Rating("2", 3.5f),
                new Rating("3", 5.0f)
        );
        UserRating userRating = UserRating.builder()
                                .ratings(rating)
                                .build();
        return userRating;
    }
}
