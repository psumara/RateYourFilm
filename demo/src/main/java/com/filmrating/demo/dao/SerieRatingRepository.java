package com.filmrating.demo.dao;

import com.filmrating.demo.entity.SerieRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRatingRepository extends JpaRepository<SerieRating, Integer> {

}
