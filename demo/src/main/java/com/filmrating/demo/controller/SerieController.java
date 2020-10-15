package com.filmrating.demo.controller;


import com.filmrating.demo.entity.Serie;
import com.filmrating.demo.service.SerieService;
import com.filmrating.demo.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/series")
public class SerieController {

    private SerieService serieService;
    private UserService userService;

    public SerieController(SerieService theSerieService, UserService theUserService) {
        serieService = theSerieService;
        userService = theUserService;
    }

    @GetMapping("/list")
    public String listSeries(Model theModel, @Param("keyword") String keyword){

        List<Serie> theSeries = serieService.findAll(keyword);
        theModel.addAttribute("series", theSeries);
        theModel.addAttribute("keyword", keyword);

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
