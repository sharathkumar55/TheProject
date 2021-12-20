package com.myproject.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_id")
    private int id;

    @Column(name="ratingreview")
    @NotNull
    private String ratingReview;


    @NotNull
    @Min(value = 0,message = "minimum value is equal to 0 or greater")
    @Max(value = 10,message = "should not exceed 10")
    @Column(name = "ratingscore")
    private int ratingScore;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatingReview() {
        return ratingReview;
    }

    public void setRatingReview(String ratingReview) {
        this.ratingReview = ratingReview;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
