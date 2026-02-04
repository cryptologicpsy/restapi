package com.example.restapi.controllers;
import com.example.restapi.Services.MoviesService;
import com.example.restapi.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  MoviesService movieService;

  public MovieController(MoviesService service)
  {
    this.movieService = service;
  }


  @GetMapping("")
  public List<Movie> getAllMovies()
  {
    return movieService.getAllMovies();

  }

  @GetMapping("/{id}")
  public Movie getMovieById(@PathVariable Long id)
  {

    return movieService.getMovieById(id);
  }


  @PostMapping("")
  public void createMovie(@RequestBody Movie movie)
  {
    movieService.post(movie);

  }


  @PutMapping("/{id}")
  public void updateMovie (@PathVariable Long id, @RequestBody Movie movie)
  {
    movieService.put(id, movie);

  }


  @DeleteMapping("/{id}")
  public void deleteMovie (@PathVariable Long id)
  {
    movieService.delete(id);

  }

}


