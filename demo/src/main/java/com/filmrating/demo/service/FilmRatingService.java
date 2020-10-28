package com.filmrating.demo.service;

import com.filmrating.demo.entity.Film;
import com.filmrating.demo.entity.FilmRating;
import com.filmrating.demo.entity.User;

import java.util.List;

public interface FilmRatingService {
    public List<FilmRating> findAll();

    public FilmRating findById(int theId);

    public void save(FilmRating theFilmRating);

    public void deleteById(int theId);

    public FilmRating findByUserAndFilm(User theUser, Film theFilm);


}
