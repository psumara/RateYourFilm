package com.filmrating.demo.service;

import com.filmrating.demo.dao.SerieRatingRepository;
import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieRatingServiceImpl implements SerieRatingService {

    private SerieRatingRepository serieRatingRepository;

    @Autowired
    public SerieRatingServiceImpl(SerieRatingRepository theSerieRatingRepository) {
        serieRatingRepository = theSerieRatingRepository;
    }

    @Override
    public List<SerieRating> findAll() {

        return serieRatingRepository.findAll();
    }

    @Override
    public SerieRating findById(int theId) {
        Optional<SerieRating> result = serieRatingRepository.findById(theId);

        SerieRating theSerieRating = null;

        if (result.isPresent()) {
            theSerieRating = result.get();
        }
        else {

            throw new RuntimeException("Did not find rating id - " + theId);
        }

        return theSerieRating;
    }

    @Override
    public void save(SerieRating theSerieRating) {
        serieRatingRepository.save(theSerieRating);
    }

    @Override
    public void deleteById(int theId) {
        serieRatingRepository.deleteById(theId);
    }

    @Override
    public SerieRating findByUserAndSerie(User theUser, Serie theSerie) {
        return serieRatingRepository.findByUserAndSerie(theUser, theSerie);
    }

    @Override
    public SerieRating findByUser(User theUser) {
        return serieRatingRepository.findByUser(theUser);
    }

    @Override
    public boolean existsByUser(User theUser) {
        return serieRatingRepository.existsByUser(theUser);
    }





}
