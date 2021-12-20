package com.myproject.demo.service;

import com.myproject.demo.converter.MovieConverter;
import com.myproject.demo.dao.MovieRepository;
import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;
import com.myproject.demo.exceptionhandler.DuplicateMovieException;
import com.myproject.demo.exceptionhandler.MovieNotIdentifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieConverter movieConverter;

    /*public List<Movie> findAll()
    {
        List<Movie> theMovie =movieRepository.findAll();

        return theMovie;
    }*/



    @Override
    public List<MovieDto> findAll() {
        List<Movie> theMovie1 = movieRepository.findAll();
        List<MovieDto> theMovie = movieConverter.entityToDto(theMovie1);
        return theMovie;
    }

    @Override
    public Movie findById(int theId) {

        Optional<Movie> result =  movieRepository.findById(theId);

        Movie theMovie = null;
        if(result.isPresent()) {
            theMovie = result.get();
        }
        else
        {

            throw new MovieNotIdentifiedException("Did not find movie id "+theId);
        }
        Movie theMovie1 = theMovie;
        return theMovie1;

    }

    public void save(Movie theMovie) {
        // movieRepository.save(theMovie);
        List<Movie> allMovies = movieRepository.findAll();
        List<String> movieNames = new ArrayList<>();
        for (Movie tempmovies : allMovies) {
            movieNames.add(tempmovies.getMovieName().toLowerCase());
        }
        if (movieNames.contains(theMovie.getMovieName().toLowerCase())) {
            throw new DuplicateMovieException("Movie Already Exits");
        } else {
            movieRepository.save(theMovie);

        }
    }

    @Override
    public void deleteById(int theId) {
        movieRepository.deleteById(theId);

    }

}
