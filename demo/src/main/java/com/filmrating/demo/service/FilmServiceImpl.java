package com.filmrating.demo.service;

import com.filmrating.demo.dao.FilmsRepository;
import com.filmrating.demo.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService{

    private FilmsRepository filmsRepository;

    @Autowired
    public FilmServiceImpl(FilmsRepository theFilmRepository) {
        filmsRepository = theFilmRepository;
    }

    @Override
    public List<Film> findAll(String keyword) {

        if(keyword != null){
            return filmsRepository.findByKeyword(keyword);
        }
        return filmsRepository.findAll();
    }

    @Override
    public Film findById(int theId) {
        Optional<Film> result = filmsRepository.findById(theId);

        Film theFilm = null;

        if (result.isPresent()) {
            theFilm = result.get();
        }
        else {

            throw new RuntimeException("Did not find film id - " + theId);
        }

        return theFilm;
    }

    @Override
    public void save(Film theFilm) {
        filmsRepository.save(theFilm);
    }

    @Override
    public void deleteById(int theId) {
        filmsRepository.deleteById(theId);
    }

}
