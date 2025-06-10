package com.saritha.movie_info_service.controller;

import com.saritha.movie_info_service.entity.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieInfoController {

    @GetMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable ("movieId") String movieId) {
        // This method should return movie information.
        // The implementation will typically involve fetching movie details from a database or another service.
        return new Movie(movieId, "Kushi");
    }
}
