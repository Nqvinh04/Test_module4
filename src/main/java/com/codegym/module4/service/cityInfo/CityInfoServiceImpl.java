package com.codegym.module4.service.cityInfo;

import com.codegym.module4.model.CityInfo;
import com.codegym.module4.repository.CityInfoRepository;
import com.codegym.module4.service.cityInfo.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityInfoServiceImpl implements CityInfoService {
    @Autowired
    private CityInfoRepository cityInfoRepository;
    @Override
    public Iterable<CityInfo> findAll() {
        return cityInfoRepository.findAll();
    }

    @Override
    public CityInfo findCityInfoById(Long id) {
        return cityInfoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CityInfo cityInfo) {
        cityInfoRepository.save(cityInfo);
    }

    @Override
    public void remove(Long id) {
        cityInfoRepository.deleteById(id);
    }


}
