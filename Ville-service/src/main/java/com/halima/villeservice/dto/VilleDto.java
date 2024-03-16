package com.halima.villeservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VilleDto {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Population must be equal or greater than 0")
    private int population;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Tourist attractions cannot be blank")
    private String touristAttractions;

    @NotBlank(message = "Climate information cannot be blank")
    private String climate;
}