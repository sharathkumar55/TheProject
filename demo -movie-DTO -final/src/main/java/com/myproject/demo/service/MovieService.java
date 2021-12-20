package com.myproject.demo.service;

import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;

import java.util.List;

public interface MovieService {

     List<MovieDto> findAll();
     public Movie findById(int theId);

     public void save(Movie theMovie);

     public void deleteById(int theId);
}
