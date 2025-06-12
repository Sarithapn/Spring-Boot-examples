package com.saritha.movie_catalog_service.service;

import com.saritha.movie_catalog_service.entity.CatalogItem;
import com.saritha.movie_catalog_service.entity.Movie;
import com.saritha.movie_catalog_service.entity.Rating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    @Autowired
    private  WebClient.Builder webClientBuilder;

    @CircuitBreaker(name = "movieCatalogCB", fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating ratings) {
        Movie movie = webClientBuilder.build().get()
                .uri("http://movie-info-service/movies/" + ratings.getMovieId())
                // .uri(" https://api.themoviedb.org/3/movie/"+ ratings.getMovieId()+"?api_key="+moviedbKey)
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
        return new CatalogItem(movie.getMovieId() + " " + movie.getMovieName(), movie.getDescription(), ratings.getRating());
    }
    public CatalogItem getFallbackCatalogItem(Rating rating, Throwable t) {
        return new CatalogItem("No movie info", "No description available", 0);
    }


}
