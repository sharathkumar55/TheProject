package com.myproject.demo.exceptionhandler;

public class DuplicateMovieException extends RuntimeException{
    public DuplicateMovieException(String message)
    {
        super(message);
    }

    public DuplicateMovieException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateMovieException(Throwable cause) {
        super(cause);
    }
}
