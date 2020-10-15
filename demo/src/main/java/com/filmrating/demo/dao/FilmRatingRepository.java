package com.filmrating.demo.dao;

import com.filmrating.demo.entity.FilmRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRatingRepository extends JpaRepository<FilmRating, Integer> {

}
