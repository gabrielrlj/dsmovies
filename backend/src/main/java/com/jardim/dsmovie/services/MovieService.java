package com.jardim.dsmovie.services;

import com.jardim.dsmovie.dto.MovieDTO;
import com.jardim.dsmovie.model.Movie;
import com.jardim.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> movies = movieRepository.findAll(pageable);
        return movies.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long idMovie){
        Movie movie = movieRepository.findMovieById(idMovie);
        if (movie == null) return null;
        return new MovieDTO(movie);
    }
}
