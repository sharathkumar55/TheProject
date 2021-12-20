package com.myproject.demo.service;

import com.myproject.demo.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> findAll();

    Rating findRatingById(int ratingId);

    void save(Rating theRating);

    void deleteRatingById(int ratingId);

    List<Rating> findRatingsByMovieId(int ratingId);
}
