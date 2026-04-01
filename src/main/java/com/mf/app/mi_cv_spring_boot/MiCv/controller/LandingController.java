package com.mf.app.mi_cv_spring_boot.MiCv.controller;

import com.mf.app.mi_cv_spring_boot.MiCv.model.CvData;
import com.mf.app.mi_cv_spring_boot.MiCv.service.CvInitializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LandingController {
    private final CvInitializationService cvInitializationService;

    @GetMapping("/")
    public String redirectToForm(){
        return "redirect:/cv-form";
    }

    @GetMapping("cv-form")
    public String showForm(Model model){
        CvData cvData = cvInitializationService.initializeCvData();
//        model.addAttribute("firstName", cvData.getPersonalDetails().getFirstName());
//        model.addAttribute("lastName", cvData.getPersonalDetails().getLastName());
//        model.addAttribute("email", cvData.getPersonalDetails().getEmail());
//        model.addAttribute("phone", cvData.getPersonalDetails().getPhone());
//        model.addAttribute("address", cvData.getPersonalDetails().getAddress());
        model.addAttribute("cvData", cvData);
        return "cv-form";
    }

    @PostMapping("/generate-cv")
    public String generateCv(@ModelAttribute CvData cvData, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("cvData", cvData);
        return "redirect:cv-display";
    }

    @GetMapping("/cv-display")
    public String displayCv(@ModelAttribute("cvData") CvData cvData, Model model){
        if (cvData.getPersonalDetails()==null){
            cvData = cvInitializationService.initializeCvData();
        }
        model.addAttribute("cvData", cvData);
        return "index";
    }

}
