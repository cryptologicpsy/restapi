package com.example.restapi.Services;


import com.example.restapi.MovieNotfoundException;
import com.example.restapi.Repositories.MovieRepository;
import com.example.restapi.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class MoviesService {

    MovieRepository movieRepository;

    public MoviesService(MovieRepository db) {
        this.movieRepository = db;
    }

    // Επιστρέφει όλες τις ταινίες
    public List<Movie> getAllMovies(){

        return movieRepository.findAll();
    }


    public Movie getMovieById( Long id) {
        return movieRepository.findById(id).orElse(null);
        }




    public void post( Movie movie){
        movieRepository.save(movie);
    }



    public void put(Long id,  Movie movie){

        Movie m = movieRepository.findById(id).orElse(null);

               // Ενημερώνει τα πεδία της
                if( m != null){
                m.setTitle(movie.getTitle());
                m.setDirector(movie.getDirector());
                m.setYear(movie.getYear());
                movieRepository.save(m);}




    }



    public void delete(Long id){

        Movie m = movieRepository.findById(id).orElse(null);
            if(m != null){
                movieRepository.delete(m);
            }


    }
   
}