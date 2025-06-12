package com.saritha.movie_catalog_service.controller;

import com.saritha.movie_catalog_service.entity.CatalogItem;
import com.saritha.movie_catalog_service.entity.Movie;
import com.saritha.movie_catalog_service.entity.Rating;
import com.saritha.movie_catalog_service.entity.UserRating;
import com.saritha.movie_catalog_service.service.MovieService;
import com.saritha.movie_catalog_service.service.MovieServiceRest;
import com.saritha.movie_catalog_service.service.UserRatingService;
import com.saritha.movie_catalog_service.service.UserRatingServiceRest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class MovieCatalogController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  WebClient.Builder webClientBuilder;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRatingService userRatingService;

    @Autowired
    private MovieServiceRest movieServiceRest;

    @Autowired
    private UserRatingServiceRest userRatingServiceRest;


    private String moviedbKey = "3071f8679c53009e6dba5dfdc88b26f7";



    @GetMapping("/catalog/{userId}")
    @CircuitBreaker(name = "movieCatalogCB", fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //get all rated movies for the user
     /*   List<Rating> rating = List.of(
                new Rating("1", 4.5f),
                new Rating("2", 3.5f),
                new Rating("3", 5.0f)
        );*/
        //usingwebclient
      // UserRating userRating = userRatingService.getUserRating(userId);

        //using rest template
        UserRating userRating = userRatingServiceRest.getUserRating(userId);


        // for each movie, get movie info and get details
       return  userRating.getRatings().stream().map(ratings -> {
          //  Movie movie  = restTemplate.getForObject("http://localhost:8082/movies/" + ratings.getMovieId(), Movie.class);
           return movieService.getCatalogItem(ratings);
       }).toList();

        //place them in a catalog item
       /* return Collections.singletonList(new CatalogItem(
                "Kushi",
                "Love story",
                4.5f
        ));*/
    }


}
