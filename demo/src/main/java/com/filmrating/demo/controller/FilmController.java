package com.filmrating.demo.controller;

import com.filmrating.demo.entity.Film;
import com.filmrating.demo.service.FilmService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService theFilmService) {
        filmService = theFilmService;
    }

    @GetMapping("/list")
    public String listFilms(Model theModel, @Param("keyword") String keyword){

        List<Film> theFilms = filmService.findAll(keyword);
        theModel.addAttribute("films", theFilms);
        theModel.addAttribute("keyword", keyword);

        return "films/list-films";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Film theFilm = new Film();

        theModel.addAttribute("film", theFilm);

        return "films/film-form-add";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("filmId")int theId, Model theModel) {

        Film theFilm = filmService.findById(theId);

        theModel.addAttribute("film", theFilm);

        return "films/film-form-update";
    }

    @GetMapping("/showFormForRate")
    public String showFormForRate(@RequestParam("filmId")int theId, Model theModel) {

        Film theFilm = filmService.findById(theId);

        theModel.addAttribute("film", theFilm);

        return "films/film-form-rate";
    }

    @PostMapping("/save")
    public String saveFilm(@ModelAttribute("film") Film theFilm){

        filmService.save(theFilm);

        return "redirect:/films/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("filmId") int theId){

        filmService.deleteById(theId);

        return "redirect:/films/list";
    }

}
