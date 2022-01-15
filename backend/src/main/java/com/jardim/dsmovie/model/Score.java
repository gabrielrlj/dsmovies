package com.jardim.dsmovie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {

    @EmbeddedId
    private MovieUser id = new MovieUser();
    private Double value;

    public Score() {}

    public Score(User user, Movie movie, Double value){
        this.setUser(user);
        this.setMovie(movie);
        this.setValue(value);
    }

    public void setMovie(Movie movie){
        this.id.setMovie(movie);
    }

    public void setUser(User user){
        this.id.setUser(user);
    }

    public Score(MovieUser id, Double value) {
        this.id = id;
        this.value = value;
    }

    public MovieUser getId() {
        return id;
    }

    public void setId(MovieUser id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
