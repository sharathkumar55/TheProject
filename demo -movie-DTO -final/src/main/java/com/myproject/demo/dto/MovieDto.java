package com.myproject.demo.dto;

import com.myproject.demo.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private int id;

    private String movieName;

      private String movieLanguage;

      List<Rating> ratings;

    public MovieDto(int id, String movieName, String movieLanguage) {
        this.id = id;
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
    }
}
