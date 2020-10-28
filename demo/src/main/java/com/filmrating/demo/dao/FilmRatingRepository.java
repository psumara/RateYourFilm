package com.filmrating.demo.dao;

import com.filmrating.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRatingRepository extends JpaRepository<FilmRating, Integer> {

    public FilmRating findByUserAndFilm(User theUser, Film theFilm);

}
