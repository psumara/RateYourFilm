package com.filmrating.demo.service;

import com.filmrating.demo.entity.FilmRating;

import java.util.List;

public interface FilmRatingService {
    public List<FilmRating> findAll();

    public FilmRating findById(int theId);

    public void save(FilmRating theFilmRating);

    public void deleteById(int theId);


}
