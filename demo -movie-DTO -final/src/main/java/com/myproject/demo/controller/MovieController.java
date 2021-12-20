package com.myproject.demo.controller;

import com.myproject.demo.converter.MovieConverter;
import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;
import com.myproject.demo.exceptionhandler.DuplicateMovieException;
import com.myproject.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    MovieConverter movieConverter;


    public MovieController(MovieService theMovieService) {
        this.movieService = theMovieService;
    }

    @GetMapping("/list")
    @Transactional
    public String listOfMovies(Model theModel)
    {
        //get employees from database
       // List<Movie> theMovies1 = movieService.findAll();
        List<MovieDto> theMovies = movieService.findAll();;
        theModel.addAttribute("movie",theMovies);
        System.out.println("the movies are");
        for(MovieDto temp : theMovies)
        {
            System.out.println("the movies are "+temp);
        }
        return "listmovies";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Movie theMovie = new Movie();

        theModel.addAttribute("movie", theMovie);

        return "Movies/movieform";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie theMovie) {
        List<MovieDto> allMovies=movieService.findAll();
        List<String> movieNames=new ArrayList<>();
        for(MovieDto tempmovies:allMovies)
        {
            movieNames.add(tempmovies.getMovieName().toUpperCase());
        }
        if(movieNames.contains(theMovie.getMovieName().toUpperCase()))
        {
            throw new DuplicateMovieException("Movie Already Exits");
        }
        else
        {
            movieService.save(theMovie);

        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/movies/list";
    }
    @GetMapping("/showFormForUpdateMovie")
    public String showFormForUpdateMovie(@RequestParam("movieId") int theId, Model theModel)
    {
        Movie theMovie=movieService.findById(theId);

        theModel.addAttribute("movie",theMovie);

        return "Movies/movieform";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("movieId") int theId)
    {
        movieService.deleteById(theId);
        return "redirect:list";
    }



}
