package com.jardim.dsmovie.repositories;

import com.jardim.dsmovie.model.Movie;
import com.jardim.dsmovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
