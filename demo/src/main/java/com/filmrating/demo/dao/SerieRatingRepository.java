package com.filmrating.demo.dao;

import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRatingRepository extends JpaRepository<SerieRating, Integer> {

    public SerieRating findByUserAndSerie(User theUser, Serie theSerie);

    boolean existsByUser(User theUser);


}
