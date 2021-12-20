package com.myproject.demo.controller;

import com.myproject.demo.dto.MovieDto;
import com.myproject.demo.entity.Movie;
import com.myproject.demo.entity.Rating;
import com.myproject.demo.service.MovieService;
import com.myproject.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MovieService movieService;


    @GetMapping("/list")
    public String listRatings(Model ratingModel)

    {
        List<Rating> theRatings =ratingService.findAll();

       // List<MovieDto> theMovies = movieService.findAll();
        List<MovieDto> theMovies = movieService.findAll();
        ratingModel.addAttribute("rating",theRatings);
        ratingModel.addAttribute("movie",theMovies);

        return "ratings/listratings";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam("movieId") int theId, Model ratingModel, Model theModel)
    {

        Movie theMovie= movieService.findById(theId);
        Rating rating=new Rating();
        theModel.addAttribute("theMovie",theMovie);
        ratingModel.addAttribute("ratings",rating);
        return "ratings/ratingform";
    }
    @PostMapping("/save")
    public String saveRating(@ModelAttribute("ratings") Rating theRating)
    {
        ratingService.save(theRating);
        return "redirect:/ratings/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("ratingId") int theId)
    {
        ratingService.deleteRatingById(theId);
        return "redirect:/movies/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ratingId") int theId,Model theModel)
    {
        Rating theRating= ratingService.findRatingById(theId);
        theModel.addAttribute("ratings",theRating);
        return "ratings/ratingform";
    }

}
