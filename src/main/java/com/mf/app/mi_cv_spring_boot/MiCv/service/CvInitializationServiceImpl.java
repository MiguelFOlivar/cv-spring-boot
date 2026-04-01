package com.mf.app.mi_cv_spring_boot.MiCv.service;

import com.mf.app.mi_cv_spring_boot.MiCv.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CvInitializationServiceImpl implements CvInitializationService{
    @Override
    public CvData initializeCvData() {

        CvData cvData = new CvData();

        //Datos Personales
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("Mike");
        personalDetails.setLastName("Bloom");
        personalDetails.setEmail("mike@mail.com");
        personalDetails.setProfessionalProfile("Backend Developer");
        cvData.setPersonalDetails(personalDetails);

        //Educación
        Education education = new Education();
        education.setInstitution("UNRC");
        education.setPeriod("2021 - 2025");
        education.setDegree("Lic. TIC");
        education.setDescription("Superior");

        //Crea una lista con un solo elemento inmutable
        cvData.setEducations(Collections.singletonList(education));

        //Experiencia
        List<Experience> experiences = new ArrayList<>();
        Experience experience1 = new Experience();

        experience1.setJobTitle("Trainee");
        experience1.setDescription("Trainee Java");
        experience1.setCompany("EPAM");
        experience1.setPeriod("2024-2026");

        experiences.add(experience1);
        cvData.setExperiences(experiences);

        //Habilidades

        Skill skill1 = new Skill();
        skill1.setName("English");
        skill1.setLevel("Intermediate");

        Skill skill2 = new Skill();
        skill2.setName("Java");
        skill2.setLevel("Intermediate");

        cvData.setSkills(List.of( skill1, skill2 ));


        return cvData;
    }
}
