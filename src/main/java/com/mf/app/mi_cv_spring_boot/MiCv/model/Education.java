package com.mf.app.mi_cv_spring_boot.MiCv.model;

import lombok.Data;

@Data
public class Education {
    private String institution;
    private String degree;
    private String period; //example: "September 2018 - June 2022"
    private String description; //Optional: details of the study
}
