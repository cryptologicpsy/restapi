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
    // TODO: Check if the movie is null and return 404 if not found


    return movieService.getMovieById(id);
  }


  @PostMapping("")
  public void createMovie(@RequestBody Movie movie)
  {
    // TODO: Currently void; consider returning created Movie and HTTP 201 status


    movieService.post(movie);

  }


  @PutMapping("/{id}")
  public void updateMovie (@PathVariable Long id, @RequestBody Movie movie)
  {
    // TODO: Currently void; consider returning updated Movie and 404 if not found

    movieService.put(id, movie);

  }


  @DeleteMapping("/{id}")
  public void deleteMovie (@PathVariable Long id)
  {
    // TODO: Currently void; consider returning 404 if movie not found

    movieService.delete(id);

  }

}


