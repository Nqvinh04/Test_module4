package com.codegym.module4.service.cityInfo;

import com.codegym.module4.model.CityInfo;

import java.util.List;

public interface CityInfoService {
    Iterable<CityInfo> findAll();

    CityInfo findCityInfoById(Long id);

    void save(CityInfo cityInfo);

    void remove(Long id);

}
