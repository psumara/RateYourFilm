package com.filmrating.demo.controller;

import com.filmrating.demo.entity.Film;
import com.filmrating.demo.entity.FilmRating;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;
import com.filmrating.demo.service.FilmService;
import com.filmrating.demo.service.FilmRatingService;
import com.filmrating.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmRatings")
public class FilmRatingController {

    private FilmService filmService;
    private UserService userService;
    private FilmRatingService filmRatingService;

    public FilmRatingController(FilmService theFilmService, UserService theUserService, FilmRatingService theFilmRatingService) {
        filmService = theFilmService;
        userService = theUserService;
        filmRatingService = theFilmRatingService;
    }

    @GetMapping("/showFormForFilmRate")
    public String showFormForFilmRate(@RequestParam("filmId")int theId, String value, Model theModel) {

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }
        else {
            username = principal.toString();
        }
        User theUser = userService.findByUsername(username);

        Film theFilm = filmService.findById(theId);

        FilmRating theFilmRating;

        List<FilmRating> filmRatingList = theFilm.getRatings();

        if(filmRatingService.findByUserAndFilm(theUser, theFilm) != null)
        {
            theFilmRating = filmRatingService.findByUserAndFilm(theUser, theFilm);
        }

        else {
            theFilmRating = new FilmRating(StringUtils.isNotBlank(value) ? Integer.parseInt(value) : 0, theFilm, theUser);
        }

        filmRatingList.add(theFilmRating);
        theFilm.setRatings(filmRatingList);

        theModel.addAttribute("film", theFilm);
        theModel.addAttribute("value", value);
        theModel.addAttribute("filmRating", theFilmRating);

        return "films/film-form-rate";
    }

    @PostMapping("/saveFilmRating")
    public String saveFilmRating(@ModelAttribute("filmRating") FilmRating theFilmRating){

        filmRatingService.save(theFilmRating);

        return "redirect:/films/list";
    }
}
