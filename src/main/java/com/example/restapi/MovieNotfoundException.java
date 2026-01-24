package com.example.restapi;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotfoundException extends RuntimeException {

    public MovieNotfoundException(){


    }
}
