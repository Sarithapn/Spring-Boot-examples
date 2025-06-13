package com.saritha.movie_info_service.controller;

import com.saritha.movie_info_service.entity.Movie;
import com.saritha.movie_info_service.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieInfoController {


    @Value("${moviedb.key}")
    private String moviedbKey;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable ("movieId") String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  moviedbKey, MovieSummary.class);
        return  new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
