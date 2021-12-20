package com.myproject.demo.exceptionhandler;

public class MovieNotIdentifiedException extends RuntimeException{
    public MovieNotIdentifiedException() {
        super();
    }

    public MovieNotIdentifiedException(String message) {
        super(message);
    }

    public MovieNotIdentifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieNotIdentifiedException(Throwable cause) {
        super(cause);
    }
}
