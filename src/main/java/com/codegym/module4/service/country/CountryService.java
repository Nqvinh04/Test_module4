package com.codegym.module4.service.country;

import com.codegym.module4.model.Country;

public interface CountryService {
    Iterable<Country> findAll();

    Country findCountryById(Long id);

    void save(Country country);

    void remove(Long id);
}
