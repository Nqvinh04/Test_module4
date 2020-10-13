package com.codegym.module4.repository;

import com.codegym.module4.model.CityInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityInfoRepository extends PagingAndSortingRepository<CityInfo, Long> {
    void deleteByCityId(CityInfo cityInfo);
}
