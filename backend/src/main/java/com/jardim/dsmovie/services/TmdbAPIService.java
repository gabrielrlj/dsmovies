package com.jardim.dsmovie.services;

import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmdbAPIService {

    @Autowired
    private TmdbMovies tmdbMovies;

    public MovieDb getOneMovie(){
        MovieDb movie = tmdbMovies.getMovie(5353, "en");
        return movie;
    }


}
