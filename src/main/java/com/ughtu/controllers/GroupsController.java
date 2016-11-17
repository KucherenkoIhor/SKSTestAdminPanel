package com.ughtu.controllers;

import com.ughtu.models.Question;
import com.ughtu.models.StudentsGroup;
import com.ughtu.models.Subject;
import com.ughtu.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by igor on 17.11.16.
 */
@Controller
public class GroupsController {

    @Autowired
    private GroupsRepository groupsRepository;

    @RequestMapping(value = "/groups")
    public String groups(Model model) {
        model.addAttribute("groups", groupsRepository.findAll());
        model.addAttribute("group", new StudentsGroup());
        return "groups";
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public String saveGroup(@ModelAttribute StudentsGroup group) {
        groupsRepository.save(group);
        return "redirect:groups";
    }

    @RequestMapping("/groups/delete/{id}")
    public String delete(@PathVariable Long id){
        groupsRepository.delete(id);
        return "redirect:/groups";
    }

}
