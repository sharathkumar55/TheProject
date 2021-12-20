package com.myproject.demo.service;

import com.myproject.demo.dao.RatingRepository;
import com.myproject.demo.entity.Movie;
import com.myproject.demo.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{

        @Autowired
        private RatingRepository ratingRepository;
    @Override
    public List<Rating> findAll() {

        return ratingRepository.findAll();
    }

    @Override
    public Rating findRatingById(int ratingId) {
        Optional<Rating> result =  ratingRepository.findById(ratingId);
        Rating theRating = null;
        if(result.isPresent()) {
            theRating = result.get();
        }
        else
        {
            //not found
            throw new RuntimeException("Did not find review id "+ratingId);
        }
        Rating theRating1 = theRating;
        return theRating1;
    }

    @Override
    public void save(Rating theRating) {
        System.out.println("calling save in rating ");
        ratingRepository.save(theRating);

    }

    @Override
    public void deleteRatingById(int ratingId) {
        Optional<Rating> result =ratingRepository.findById(ratingId);
        if(result.isEmpty())
        {
            //throw new Rating("Cannot find review with id:"+reviewId);
        }
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public List<Rating> findRatingsByMovieId(int ratingId) {
        return null;
    }
}
