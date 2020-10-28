package com.filmrating.demo.service;

import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;

import java.util.List;

public interface SerieRatingService {
    public List<SerieRating> findAll();

    public SerieRating findById(int theId);

    public void save(SerieRating theSerieRating);

    public void deleteById(int theId);

    public SerieRating findByUserAndSerie(User theUser, Serie theSerie);

    public SerieRating findByUser(User theUser);

    boolean  existsByUser(User theUser);


}
