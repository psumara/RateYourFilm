package com.filmrating.demo.service;

import com.filmrating.demo.entity.SerieRating;

import java.util.List;

public interface SerieRatingService {
    public List<SerieRating> findAll();

    public SerieRating findById(int theId);

    public void save(SerieRating theSerieRating);

    public void deleteById(int theId);


}
