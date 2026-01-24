package com.example.restapi.controllers;


import com.example.restapi.MovieNotfoundException;
import com.example.restapi.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();
    private Integer nextid = 1;

    public MovieController(){

        movies.add(new Movie(nextid++, "title1", "director1", 2015));
        movies.add(new Movie(nextid++, "title2", "director2", 2015));
        movies.add(new Movie(nextid++, "title3", "director3", 2015));
    }


    @GetMapping("")
    public List<Movie> getAllMovies(){

      return movies;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {

       // Movie movie = null;

        for(Movie m: movies){

            if(m.getId() == id) {
                return m;
            }
        }
     throw new MovieNotfoundException();
    }


    @PostMapping("")

    public void createMovie(@RequestBody Movie movie){

        movie.setId(nextid++);

        movies.add(movie);
    }


    @PutMapping("/{id}")
    public void updateMovie (@PathVariable int id, @RequestBody Movie movie){


        for(Movie m: movies){

            if(m.getId() == id) {
                m.setTitle(movie.getTitle());
                m.setDirector(movie.getDirector());
                m.setYear(movie.getYear());
                break;
            }
        }


    }


    @DeleteMapping("/{id}")

    public void deleteMovie (@PathVariable int id){


        for(Movie m: movies){

            if(m.getId() == id) {
                movies.remove(m);
                break;
            }
        }


    }





}
