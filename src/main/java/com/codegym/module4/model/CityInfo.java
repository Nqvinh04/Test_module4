package com.codegym.module4.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Value;
import org.aspectj.bridge.IMessage;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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

    @NotNull
    @Min(value = 10)
    private int population;

    @NotNull
    @Min(value = 100)
    private int gdp;

    @NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String description;
}
