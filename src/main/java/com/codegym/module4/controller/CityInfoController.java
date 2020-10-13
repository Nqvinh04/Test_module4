package com.codegym.module4.controller;

import com.codegym.module4.model.CityInfo;
import com.codegym.module4.model.Country;
import com.codegym.module4.service.cityInfo.CityInfoService;
import com.codegym.module4.service.country.CountryService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cityinfo")
public class CityInfoController {
    @Autowired
    private CityInfoService cityInfoService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countrys")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView index(){
        Iterable<CityInfo> cityInfo = cityInfoService.findAll();
        ModelAndView modelAndView = new ModelAndView("/cityInfo/list");
        modelAndView.addObject("cityInfo", cityInfo);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/cityInfo/create");
        modelAndView.addObject("cityInfo", new CityInfo());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView saveCityInfo(CityInfo cityInfo){
        cityInfoService.save(cityInfo);
        ModelAndView modelAndView = new ModelAndView("/cityInfo/create");
        modelAndView.addObject("cityInfo", new CityInfo());
        modelAndView.addObject("message", " New cityInfo created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/cityInfo/edit");
        modelAndView.addObject("cityInfo", cityInfoService.findCityInfoById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCityInfo(CityInfo cityInfo){
        cityInfoService.save(cityInfo);
        ModelAndView modelAndView = new ModelAndView("/cityInfo/edit");
        modelAndView.addObject("cityInfo", cityInfo);
        modelAndView.addObject("message", "CityInfo updated successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        CityInfo cityInfo = cityInfoService.findCityInfoById(id);
        ModelAndView modelAndView = new ModelAndView("/cityInfo/delete");
        modelAndView.addObject("cityInfo" , cityInfo);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCityInfo(@ModelAttribute("cityInfo") CityInfo cityInfo){
        cityInfoService.remove(cityInfo.getCityId());
        return "redirect:/cityinfo";
   }

    @GetMapping("/view/{id}")
    public ModelAndView viewCityInfo(@PathVariable Long id){
        CityInfo cityInfo = cityInfoService.findCityInfoById(id);
        ModelAndView modelAndView = new ModelAndView("/cityInfo/view");
        modelAndView.addObject("cityInfo", cityInfo);
        return modelAndView;
    }
}
