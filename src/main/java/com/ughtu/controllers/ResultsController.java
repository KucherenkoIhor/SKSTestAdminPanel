package com.ughtu.controllers;

import com.ughtu.models.Answer;
import com.ughtu.models.Result;
import com.ughtu.models.StudentsGroup;
import com.ughtu.repositories.GroupsRepository;
import com.ughtu.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * Created by igor on 17.11.16.
 */
@Controller
public class ResultsController {

    @Autowired
    private ResultRepository resultRepository;

    private long mSubjectId;

    @RequestMapping(value = "/results/{subjectId}")
    public String results(Model model, @PathVariable Long subjectId) {
        mSubjectId = subjectId;
        List<Result> results = resultRepository.findBySubjectId(subjectId);
        model.addAttribute("results", results);
        model.addAttribute("result", new Result());
        return "results";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public String save(@ModelAttribute Result result) {
        result.setSubjectId(mSubjectId);
        resultRepository.save(result);
        return "redirect:/results/" + mSubjectId;
    }

    @RequestMapping("/results/delete/{id}")
    public String delete(@PathVariable Long id){
        resultRepository.delete(id);
        return "redirect:/results/" + mSubjectId;
    }

}
