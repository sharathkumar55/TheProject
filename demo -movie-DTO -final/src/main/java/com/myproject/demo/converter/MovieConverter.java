package com.myproject.demo.converter;

import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieConverter {

    public MovieDto entityToDto(Movie movie)
    {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setMovieName(movie.getMovieName());
        movieDto.setMovieLanguage(movie.getMovieLanguage());
        movieDto.setRatings(movie.getRatings());
        return movieDto;
    }

    public Movie dtoToEntity(MovieDto movieDto)
    {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setMovieName(movieDto.getMovieName());
        movie.setMovieLanguage(movieDto.getMovieLanguage());
        movie.setRatings(movieDto.getRatings());
        return movie;
    }
    public List<MovieDto>  entityToDto(List<Movie> movie)
    {
        return movie.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
    public List<Movie> dtoToEntity(List<MovieDto> movieDto)
    {
        return movieDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }


}
