package com.jardim.dsmovie.controllers;

import com.jardim.dsmovie.services.TmdbAPIService;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TmdbMovieController {

    @Autowired
    private TmdbAPIService tmdbAPIService;

    @GetMapping("/test")
    public MovieDb getOneMovie(){
        return tmdbAPIService.getOneMovie();
    }

}
