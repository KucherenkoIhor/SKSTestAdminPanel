package com.ughtu.controllers;

import com.ughtu.models.Subject;
import com.ughtu.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by igor on 23.10.16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "redirect:subject";
    }
}
