package com.codegym.module4.formatter;

import com.codegym.module4.model.Country;
import com.codegym.module4.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFormatter implements Formatter<Country> {

    private CountryService countryService;

    @Autowired
    public CountryFormatter(CountryService countryService){
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findCountryById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getCountryId() + "," + object.getCountryName() + "]";
    }
}
