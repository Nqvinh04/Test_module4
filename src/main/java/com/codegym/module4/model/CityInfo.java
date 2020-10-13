package com.codegym.module4.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "city_info")
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;


    @Column(name = "city_nane")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_name")
    private Country countryName;


    private Double acreage;

    @NotNull

    private int population;

    @NotNull
    private int gdp;

    @Column(columnDefinition = "LONGTEXT")
    private String description;
}
