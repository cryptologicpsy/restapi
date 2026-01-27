package com.example.restapi.Services;


import com.example.restapi.MovieNotfoundException;
import com.example.restapi.models.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// Ορίζει ότι αυτή η κλάση είναι ένα Spring Service component
// Θα γίνει automatically detected από το Spring για dependency injection
@Service
public class MoviesService {

    // Λίστα που αποθηκεύει όλες τις ταινίες (in-memory storage)
    private List<Movie> movies = new ArrayList<>();

    // Μεταβλητή που κρατάει το επόμενο διαθέσιμο ID για νέες ταινίες
    private Integer nextid = 1;

    // Constructor που αρχικοποιεί το service με 3 δείγματα ταινιών
    public MoviesService(){
        movies.add(new Movie(nextid++, "title1", "director1", 2015));
        movies.add(new Movie(nextid++, "title2", "director2", 2015));
        movies.add(new Movie(nextid++, "title3", "director3", 2015));
    }


    // Επιστρέφει όλες τις ταινίες
    public List<Movie> getAllMovies(){
        return movies;
    }


    // Αναζητά και επιστρέφει μία ταινία με βάση το ID
    // Αν δεν βρεθεί, πετάει MovieNotfoundException
    public Movie getMovieById( int id) {

        // Movie movie = null;

        // Διατρέχει όλες τις ταινίες
        for(Movie m: movies){
            // Αν βρεθεί ταινία με το συγκεκριμένο ID
            if(m.getId() == id) {
                return m;
            }
        }
        // Αν δεν βρεθεί καμία ταινία, πετάει exception
        throw new MovieNotfoundException();
    }



    // Δημιουργεί νέα ταινία
    // Αναθέτει αυτόματα το επόμενο διαθέσιμο ID και την προσθέτει στη λίστα
    public void post( Movie movie){
        // Ορίζει το ID της νέας ταινίας και αυξάνει το nextid
        movie.setId(nextid++);
        // Προσθέτει την ταινία στη λίστα
        movies.add(movie);
    }



    // Ενημερώνει μία υπάρχουσα ταινία με βάση το ID
    // Ενημερώνει μόνο τα πεδία title, director, year (όχι το ID)
    public void put(int id,  Movie movie){

        // Διατρέχει όλες τις ταινίες
        for(Movie m: movies){
            // Βρίσκει την ταινία με το συγκεκριμένο ID
            if(m.getId() == id) {
                // Ενημερώνει τα πεδία της
                m.setTitle(movie.getTitle());
                m.setDirector(movie.getDirector());
                m.setYear(movie.getYear());
                // Διακόπτει το loop αφού βρέθηκε η ταινία
                break;
            }
        }
    }



    // Διαγράφει μία ταινία με βάση το ID
    public void delete(int id){

        // Διατρέχει όλες τις ταινίες
        for(Movie m: movies){
            // Βρίσκει την ταινία με το συγκεκριμένο ID
            if(m.getId() == id) {
                // Αφαιρεί την ταινία από τη λίστα
                movies.remove(m);
                // Διακόπτει το loop αφού βρέθηκε και διαγράφηκε η ταινία
                break;
            }
        }
    }

}