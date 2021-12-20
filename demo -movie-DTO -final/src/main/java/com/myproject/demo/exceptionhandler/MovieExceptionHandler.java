package com.myproject.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler
    public String handleException(MovieNotIdentifiedException exc)
    {
        return "/error/movie-not-found";
    }

    @ExceptionHandler
    public String handleException(DuplicateMovieException exc)
    {
        return "/error/movie-already-exist";
    }
}
