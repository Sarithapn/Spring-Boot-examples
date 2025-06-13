package com.saritha.movie_catalog_service.service;

import com.saritha.movie_catalog_service.entity.CatalogItem;
import com.saritha.movie_catalog_service.entity.Movie;
import com.saritha.movie_catalog_service.entity.Rating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieServiceRest {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "movieCatalogCBRest", fallbackMethod = "getFallbackCatalogItemRest")
    public CatalogItem getCatalogItem(Rating ratings) {
        Movie movie =restTemplate.getForObject("http://movie-info-service/movies/" + ratings.getMovieId(), Movie.class);
        return new CatalogItem(movie.getMovieId() + " " + movie.getMovieName(), movie.getDescription(), ratings.getRating());
    }
    public CatalogItem getFallbackCatalogItemRest(Rating rating, Throwable t) {
        return new CatalogItem("No movie info", "No description available", 0);
    }


}
