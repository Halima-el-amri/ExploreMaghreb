package com.halima.cityreviw.dto;

import lombok.Data;

@Data

public class ReviwDTO {


        private Long id;
        private Long cityServiceId;
        private Long visitorServiceId;
        private int rating;
        private String comment;

    }
