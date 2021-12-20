package com.myproject.demo.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int id;

    @NotNull()
    @NotBlank(message = "please enter")
    @Column(name="moviename")
    private String movieName;



    @NotNull()
    @NotBlank(message = "please enter ")
    @Column(name="movielanguage")
    private String movieLanguage;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private List<Rating> ratings;

    public Movie(int id,String name,String movieLanguage)
    {
        this.id=id;
        this.movieName=name;
        this.movieLanguage = movieLanguage;
    }


}
