package com.filmrating.demo.service;

import com.filmrating.demo.entity.Serie;

import java.util.List;

public interface SerieService {
    public List<Serie> findAll(String keyword);

    public Serie findById(int theId);

    public void save(Serie theSerie);

    public void deleteById(int theId);


}
