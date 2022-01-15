package com.jardim.dsmovie.controllers;

import com.jardim.dsmovie.dto.MovieDTO;
import com.jardim.dsmovie.dto.ScoreDTO;
import com.jardim.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
        MovieDTO movieDTO = scoreService.saveScoreAndCalculateAverageAndCreateUserIfNecessary(scoreDTO);
        return movieDTO;
    }

}
