package com.ughtu.controllers;

import com.ughtu.models.Result;
import com.ughtu.models.StudentsGroup;
import com.ughtu.repositories.GroupsRepository;
import com.ughtu.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by igor on 17.11.16.
 */
@Controller
public class ResultsController {

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(value = "/results/{subjectId}")
    public String results(Model model, @PathVariable Long subjectId) {

        for(int i = 0; i < 10; i ++) {
            Result result = new Result();
            result.setSubjectId(subjectId);
            result.setGroupName("CКС - 8");
            result.setValue(30 * i);
            result.setYear("2012");
            resultRepository.save(result);
        }

        List<Result> results = resultRepository.findBySubjectId(subjectId);
        model.addAttribute("results", results);
        model.addAttribute("result", new Result());
        return "results";
    }

    @RequestMapping(value="/json")
    public @ResponseBody String getAllWord() {

        return "{\n" +
                "  \"cols\": [\n" +
                "        {\"id\":\"\",\"label\":\"Topping\",\"pattern\":\"\",\"type\":\"string\"},\n" +
                "        {\"id\":\"\",\"label\":\"Какой-то предмет\",\"pattern\":\"\",\"type\":\"number\"}\n" +
                "      ],\n" +
                "  \"rows\": [\n" +
                "        {\"c\":[{\"v\":\"2011\",\"f\":null},{\"v\":35,\"f\":null}]},\n" +
                "        {\"c\":[{\"v\":\"2012\",\"f\":null},{\"v\":100,\"f\":null}]},\n" +
                "        {\"c\":[{\"v\":\"2013\",\"f\":null},{\"v\":19,\"f\":null}]},\n" +
                "        {\"c\":[{\"v\":\"2014\",\"f\":null},{\"v\":79,\"f\":null}]},\n" +
                "        {\"c\":[{\"v\":\"2015\",\"f\":null},{\"v\":25,\"f\":null}]}\n" +
                "      ]\n" +
                "}";

    }


}
