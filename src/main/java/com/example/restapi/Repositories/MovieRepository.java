package com.example.restapi.Repositories;

import com.example.restapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MovieRepository extends JpaRepository<Movie, Long> {


}

