package com.jardim.dsmovie.repositories;

import com.jardim.dsmovie.model.MovieUser;
import com.jardim.dsmovie.model.Score;
import com.jardim.dsmovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, MovieUser> {
    
}
