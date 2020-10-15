package com.filmrating.demo.dao;

import com.filmrating.demo.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Serie, Integer> {

    @Query(value = "SELECT * FROM `movies-ratings`.series e where e.title like %?1%", nativeQuery = true)
    List<Serie> findByKeyword(String keyword);
}
