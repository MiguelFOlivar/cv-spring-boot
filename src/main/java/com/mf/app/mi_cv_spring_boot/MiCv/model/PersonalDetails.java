package com.mf.app.mi_cv_spring_boot.MiCv.model;

import lombok.Data;

@Data
public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String professionalProfile;

}
