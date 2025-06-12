package com.saritha.movie_Rating_service.controller;

import com.saritha.movie_Rating_service.entity.Rating;
import com.saritha.movie_Rating_service.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MovieRatingController {


    private final AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/ratingsdata/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        // In a real application, you would fetch the rating from a database or another service.
        // Here, we are returning a hardcoded value for demonstration purposes.
        return new Rating(movieId, 4.5f);
    }

   // @GetMapping("/ratingsdata/users/{userId}")
    @GetMapping(value = "/ratingsdata/users/{userId}", produces = "application/json")
    public UserRating getuserRating(@PathVariable String userId) {
        List<Rating> rating = List.of(
                new Rating("500", 4.5f),
                new Rating("200", 3.5f),
                new Rating("400", 5.0f)
        );
        int current = counter.incrementAndGet();
        int sleepTime = (current % 2 == 0) ? 4000 : 2000; // 3 sec for even, 4 sec for odd
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is sleeping for " + sleepTime + " milliseconds." + " Current count: " + current);
            Thread.sleep(sleepTime); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Optionally log or handle the interruption
        }        UserRating userRating = UserRating.builder()
                                .ratings(rating)
                                .build();
        return userRating;
    }
}
