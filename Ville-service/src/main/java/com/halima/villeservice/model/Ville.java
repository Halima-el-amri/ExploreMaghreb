package com.halima.villeservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "Cities")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int population;
    private String country;
    private String description; // A brief description or history of the city
    private String touristAttractions; // Main tourist attractions in the city
    private String climate; // Information about the city's climate
}