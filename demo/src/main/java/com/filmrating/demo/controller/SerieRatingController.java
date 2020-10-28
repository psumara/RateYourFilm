package com.filmrating.demo.controller;

import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;
import com.filmrating.demo.service.SerieRatingService;
import com.filmrating.demo.service.SerieService;
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
@RequestMapping("/serieRatings")
public class SerieRatingController {

    private SerieService serieService;
    private UserService userService;
    private SerieRatingService serieRatingService;

    public SerieRatingController(SerieService theSerieService, UserService theUserService, SerieRatingService theSerieRatingService) {
        serieService = theSerieService;
        userService = theUserService;
        serieRatingService = theSerieRatingService;
    }

    @GetMapping("/showFormForSerieRate")
    public String showFormForSerieRate(@RequestParam("serieId")int theId, String value, Model theModel) {

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }
        else {
            username = principal.toString();
        }

        User theUser = userService.findByUsername(username);

        Serie theSerie = serieService.findById(theId);

        SerieRating theSerieRating;

        List<SerieRating> serieRatingList = theSerie.getRatings();


        if(serieRatingService.findByUserAndSerie(theUser, theSerie) != null)
        {
            theSerieRating = serieRatingService.findByUserAndSerie(theUser, theSerie);
        }

        else {
            theSerieRating = new SerieRating(StringUtils.isNotBlank(value) ? Integer.parseInt(value) : 0, theSerie, theUser);
        }
        serieRatingList.add(theSerieRating);
        theSerie.setRatings(serieRatingList);

        theModel.addAttribute("serie", theSerie);
        theModel.addAttribute("value", value);
        theModel.addAttribute("serieRating", theSerieRating);



        return "series/serie-form-rate";
    }

    @PostMapping("/saveSerieRating")
    public String saveSerieRating(@ModelAttribute("rating") SerieRating theSerieRating){

        serieRatingService.save(theSerieRating);

        return "redirect:/series/list";
    }
}
