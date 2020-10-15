package com.filmrating.demo.service;

import com.filmrating.demo.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmService {
    public List<Film> findAll(String keyword);

    public Film findById(int theId);

    public void save(Film theFilm);

    public void deleteById(int theId);


}
