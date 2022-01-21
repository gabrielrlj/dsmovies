package com.jardim.dsmovie.beans;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TmdbMovieConfig {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Bean
    public TmdbMovies tmdbMovies(){
        return new TmdbApi(apiKey).getMovies();
    }

}
