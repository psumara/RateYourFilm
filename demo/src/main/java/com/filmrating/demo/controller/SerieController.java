package com.filmrating.demo.controller;


import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.entity.SerieRating;
import com.filmrating.demo.entity.User;
import com.filmrating.demo.service.SerieRatingService;
import com.filmrating.demo.service.SerieService;
import com.filmrating.demo.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/series")
public class SerieController {

    private SerieService serieService;
    private UserService userService;
    private SerieRatingService serieRatingService;

    public SerieController(SerieService theSerieService, UserService theUserService, SerieRatingService theSerieRatingService) {
        serieService = theSerieService;
        userService = theUserService;
        serieRatingService = theSerieRatingService;
    }

    @GetMapping("/list")
    public String listSeries(Model theModel, @Param("keyword") String keyword){

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            username = ((UserDetails)principal).getUsername();
        }
        else {
            username = principal.toString();
        }

        User theUser = userService.findByUsername(username);

        List<Serie> theSeries = serieService.findAll(keyword);

        theModel.addAttribute("series", theSeries);
        theModel.addAttribute("keyword", keyword);
        theModel.addAttribute("theService", serieService);
        theModel.addAttribute("theRatingService", serieRatingService);
        theModel.addAttribute("user", theUser);

        return "series/list-series";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Serie theSerie = new Serie();

        theModel.addAttribute("serie", theSerie);

        return "series/serie-form-add";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("serieId")int theId, Model theModel) {

        Serie theSerie = serieService.findById(theId);

        theModel.addAttribute("serie", theSerie);

        return "series/serie-form-update";
    }


    @PostMapping("/save")
    public String saveSerie(@ModelAttribute("serie") Serie theSerie){

        serieService.save(theSerie);

        return "redirect:/series/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("serieId") int theId){

        serieService.deleteById(theId);

        return "redirect:/series/list";
    }

}
