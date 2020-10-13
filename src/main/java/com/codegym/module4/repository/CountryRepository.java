package com.codegym.module4.repository;

import com.codegym.module4.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
