package com.codegym.module4.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table(name = "city_info")
public class CityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;

    @NotBlank(message = "City Name not bank")
    @Column(name = "city_nane")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_name")
    private Country countryName;

    private Double acreage;


    private int population;

    private int gdp;

    @NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String description;
}
