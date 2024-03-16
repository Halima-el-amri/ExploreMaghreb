package com.halima.guidtourservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidTourDTO {

    private int id;
    private String nom;
    private String email;
    private String mot_de_passe;
    private String description;
    private String age;
    private String ville;
    private List<String> langues;

}