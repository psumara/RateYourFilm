package com.filmrating.demo.service;

import com.filmrating.demo.dao.FilmRatingRepository;
import com.filmrating.demo.entity.FilmRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmRatingServiceImpl implements FilmRatingService {

    private FilmRatingRepository filmRatingRepository;

    @Autowired
    public FilmRatingServiceImpl(FilmRatingRepository theFilmRatingRepository) {
        filmRatingRepository = theFilmRatingRepository;
    }

    @Override
    public List<FilmRating> findAll() {

        return filmRatingRepository.findAll();
    }

    @Override
    public FilmRating findById(int theId) {
        Optional<FilmRating> result = filmRatingRepository.findById(theId);

        FilmRating theFilmRating = null;

        if (result.isPresent()) {
            theFilmRating = result.get();
        }
        else {

            throw new RuntimeException("Did not find rating id - " + theId);
        }

        return theFilmRating;
    }

    @Override
    public void save(FilmRating theFilmRating) {
        filmRatingRepository.save(theFilmRating);
    }

    @Override
    public void deleteById(int theId) {
        filmRatingRepository.deleteById(theId);
    }

}
