package com.example.restapi.controllers;
import com.example.restapi.Services.MoviesService;
import com.example.restapi.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Ορίζει ότι αυτή η κλάση είναι ένας REST controller
@RestController
// Ορίζει το base path για όλα τα endpoints αυτού του controller
@RequestMapping("/api/movies")
public class MovieController {

  // Dependency injection του MoviesService
  MoviesService movieService;

  // Constructor-based dependency injection (προτιμότερο από @Autowired)
  public MovieController(MoviesService movieService) {
    this.movieService = movieService;
  }


  // GET endpoint που επιστρέφει όλες τις ταινίες
  // URL: GET /api/movies
  @GetMapping("")
  public List<Movie> getAllMovies(){
    return movieService.getAllMovies();
  }

  // GET endpoint που επιστρέφει μία ταινία με βάση το id
  // URL: GET /api/movies/{id}
  // Το @PathVariable δεσμεύει το {id} από το URL στην παράμετρο int id
  @GetMapping("/{id}")
  public Movie getMovieById(@PathVariable int id) {
    return movieService.getMovieById(id);
  }


  // POST endpoint για δημιουργία νέας ταινίας
  // URL: POST /api/movies
  // Το @RequestBody μετατρέπει το JSON του request body σε Movie object
  @PostMapping("")
  public void createMovie(@RequestBody Movie movie){
    movieService.post(movie);
  }


  // PUT endpoint για ενημέρωση υπάρχουσας ταινίας
  // URL: PUT /api/movies/{id}
  // Παίρνει το id από το URL και τα νέα δεδομένα από το request body
  @PutMapping("/{id}")
  public void updateMovie (@PathVariable int id, @RequestBody Movie movie){
    movieService.put(id, movie);
  }


  // DELETE endpoint για διαγραφή ταινίας
  // URL: DELETE /api/movies/{id}
  @DeleteMapping("/{id}")
  public void deleteMovie (@PathVariable int id){
    movieService.delete(id);
  }

}