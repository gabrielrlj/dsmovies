package com.jardim.dsmovie.controllers;

import com.jardim.dsmovie.dto.MovieDTO;
import com.jardim.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = {"/movies", "/"})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public Page<MovieDTO> findAll(@PageableDefault(size = 20, sort = {"title"}) Pageable pageable){
        return movieService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable("id") Long id){
        MovieDTO movieDTO = movieService.findById(id);

        ResponseEntity resposta;

        if (movieDTO != null){
            resposta = new ResponseEntity<>(movieDTO, HttpStatus.OK);
        }else{
            resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return resposta;
    }

}
