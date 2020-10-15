package com.filmrating.demo.service;

import com.filmrating.demo.dao.SeriesRepository;
import com.filmrating.demo.entity.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieServiceImpl implements SerieService{

    private SeriesRepository seriesRepository;

    @Autowired
    public SerieServiceImpl(SeriesRepository theSerieRepository) {
        seriesRepository = theSerieRepository;
    }

    @Override
    public List<Serie> findAll(String keyword) {

        if(keyword != null){
            return seriesRepository.findByKeyword(keyword);
        }
        return seriesRepository.findAll();
    }

    @Override
    public Serie findById(int theId) {
        Optional<Serie> result = seriesRepository.findById(theId);

        Serie theSerie = null;

        if (result.isPresent()) {
            theSerie = result.get();
        }
        else {

            throw new RuntimeException("Did not find serie id - " + theId);
        }

        return theSerie;
    }

    @Override
    public void save(Serie theSerie) {
        seriesRepository.save(theSerie);
    }

    @Override
    public void deleteById(int theId) {
        seriesRepository.deleteById(theId);
    }

}
