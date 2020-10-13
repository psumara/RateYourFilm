package com.filmrating.demo.dao;

import com.filmrating.demo.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT * FROM `movies-ratings`.films e where e.title like %?1%", nativeQuery = true)
    List<Film> findByKeyword(String keyword);
}
