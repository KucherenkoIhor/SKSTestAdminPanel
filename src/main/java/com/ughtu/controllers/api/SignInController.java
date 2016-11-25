package com.ughtu.controllers.api;

import com.ughtu.models.StudentsGroup;
import com.ughtu.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 25.11.16.
 */
@Controller
public class SignInController {

    @Autowired
    private GroupsRepository groupsRepository;

    @RequestMapping(
            path = "/api/groups",
            method =  RequestMethod.GET)
    public @ResponseBody List<StudentsGroup> getGroups() {
        List<StudentsGroup> result = new ArrayList<>();
        try {
            groupsRepository.findAll().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
