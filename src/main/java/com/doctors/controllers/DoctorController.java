package com.doctors.controllers;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doctors.beans.Doctor;
import com.doctors.dao.DoctorDao;

@Controller
public class DoctorController {
    private final DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping({"/", "/doctorsearchform"})
    public String searchForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctorsearchform";
    }

    @PostMapping("/checkDoctorsOnline")
    public ModelAndView checkDoctorsOnline(@ModelAttribute("doctor") Doctor doctor) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        try {
            Doctor result = null;
            if (doctor.getDoctorName() != null && !doctor.getDoctorName().trim().isEmpty()) {
                result = doctorDao.getDoctorsByName(doctor.getDoctorName().trim());
            } else if (doctor.getDoctorRegistrationNumber() != null
                    && !doctor.getDoctorRegistrationNumber().trim().isEmpty()) {
                result = doctorDao.getDoctorsByRegistrationNumber(doctor.getDoctorRegistrationNumber().trim());
            }

            if (result != null) {
                modelAndView.addObject("DoctorName", result.getDoctorName());
                modelAndView.addObject("RegistrationNumber", result.getDoctorRegistrationNumber());
                modelAndView.addObject("Qualification", result.getQualification());
                modelAndView.addObject("Gender", result.getGender());
            } else {
                modelAndView.addObject("DoctorName", "Not Found");
                modelAndView.addObject("RegistrationNumber", "Not Available Online");
                modelAndView.addObject("Qualification", "Not Available");
                modelAndView.addObject("Gender", "Not Available");
            }
        } catch (EmptyResultDataAccessException exception) {
            modelAndView.addObject("DoctorName", "Not Found");
            modelAndView.addObject("RegistrationNumber", "Not Available Online");
            modelAndView.addObject("Qualification", "Not Available");
            modelAndView.addObject("Gender", "Not Available");
        } catch (DataAccessException exception) {
            modelAndView.addObject("ErrorMessage",
                    "Cannot connect to MySQL. Start MySQL and check database.properties.");
        } catch (SQLException exception) {
            modelAndView.addObject("ErrorMessage", "The doctor search could not be completed.");
        }
        return modelAndView;
    }
}