package com.jardim.dsmovie.services;

import com.jardim.dsmovie.dto.MovieDTO;
import com.jardim.dsmovie.dto.ScoreDTO;
import com.jardim.dsmovie.model.Movie;
import com.jardim.dsmovie.model.Score;
import com.jardim.dsmovie.model.User;
import com.jardim.dsmovie.repositories.MovieRepository;
import com.jardim.dsmovie.repositories.ScoreRepository;
import com.jardim.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScoreAndCalculateAverageAndCreateUserIfNecessary(ScoreDTO scoreDTO){
        User user = recuperarOuSalvarUsuario(scoreDTO);
        Movie movie = recuperarFilme(scoreDTO);
        
        Score score = new Score(user, movie, scoreDTO.getScore());
        score = scoreRepository.saveAndFlush(score);
        movie = setNewAvaliation(movie);
        return new MovieDTO(movie);
    }

    private Movie setNewAvaliation(Movie movie) {
        Integer qtdAval = movie.getScores().size();
        double sum = movie.getScores().stream().mapToDouble(Score::getValue).sum();
        double avg = sum / qtdAval;

        movie.setScore(avg);
        movie.setCount(qtdAval);
        movie = movieRepository.saveAndFlush(movie);
        return movie;
    }

    private Movie recuperarFilme(ScoreDTO scoreDTO) {
        Movie movie = movieRepository.findMovieById(scoreDTO.getMovieId());
        return movie;
    }

    private User recuperarOuSalvarUsuario(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        
        return user;
    }

}
