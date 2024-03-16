package com.halima.cityreviw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviw {
    private Long id;
    private Long cityServiceId;
    private Long visitorServiceId;
    private int rating;
    private String comment;
}