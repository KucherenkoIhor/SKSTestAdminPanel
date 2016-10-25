package com.ughtu.controllers;

import com.ughtu.models.Subject;
import com.ughtu.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by igor on 25.10.16.
 */
@Controller
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "/subject")
    public String subject(Model model) {
        model.addAttribute("subjects", subjectRepository.findAll());
        model.addAttribute("subject", new Subject());
        return "subject";
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute Subject subject) {
        subjectRepository.save(subject);
        return "redirect:subject";
    }

}
