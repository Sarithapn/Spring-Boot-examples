package com.saritha.movie_catalog_service.controller;

import com.saritha.movie_catalog_service.entity.CatalogItem;
import com.saritha.movie_catalog_service.entity.Movie;
import com.saritha.movie_catalog_service.entity.Rating;
import com.saritha.movie_catalog_service.entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieCatalogController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  WebClient.Builder webClientBuilder;



    @GetMapping("/catalog/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //get all rated movies for the user
     /*   List<Rating> rating = List.of(
                new Rating("1", 4.5f),
                new Rating("2", 3.5f),
                new Rating("3", 5.0f)
        );*/
        UserRating userRating = webClientBuilder.build()
                .get()
                .uri("http://movie-Rating-service/ratingsdata/users/kushi")
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();


        // for each movie, get movie info and get details
       return  userRating.getRatings().stream().map(ratings -> {
          //  Movie movie  = restTemplate.getForObject("http://localhost:8082/movies/" + ratings.getMovieId(), Movie.class);
             Movie movie = webClientBuilder.build().get()
                   .uri("http://movie-info-service/movies/" + ratings.getMovieId())
                   .retrieve()
                   .bodyToMono(Movie.class)
                     .block();

            return new CatalogItem(movie.getMovieId()+" "+movie.getMovieName(), "Description for " + ratings.getMovieId(), ratings.getRating());
        }).toList();


        //place them in a catalog item



       /* return Collections.singletonList(new CatalogItem(
                "Kushi",
                "Love story",
                4.5f
        ));*/
    }

}
