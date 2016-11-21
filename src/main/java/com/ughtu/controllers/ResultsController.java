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
import java.util.Random;

/**
 * Created by igor on 17.11.16.
 */
@Controller
public class ResultsController {

    @Autowired
    private ResultRepository resultRepository;

    @RequestMapping(value = "/results/{subjectId}")
    public String results(Model model, @PathVariable Long subjectId) {

        Result result = new Result();
        result.setSubjectId(subjectId);
        result.setGroupName("CКС - 6");
        result.setValue(59);
        result.setYear("2011");
        resultRepository.save(result);


        Result result1 = new Result();
        result1.setSubjectId(subjectId);
        result1.setGroupName("ИС - 60");
        result1.setValue(54);
        result1.setYear("2011");
        resultRepository.save(result1);


        Result result2 = new Result();
        result2.setSubjectId(subjectId);
        result2.setGroupName("CКС - 6");
        result2.setValue(60);
        result2.setYear("2013");
        resultRepository.save(result2);

        Result result6 = new Result();
        result6.setSubjectId(subjectId);
        result6.setGroupName("CКС - 1");
        result6.setValue(23);
        result6.setYear("2013");
        resultRepository.save(result6);

        Result result8 = new Result();
        result8.setSubjectId(subjectId);
        result8.setGroupName("CКС - 1");
        result8.setValue(79);
        result8.setYear("2015");
        resultRepository.save(result8);

        Result result7 = new Result();
        result7.setSubjectId(subjectId);
        result7.setGroupName("CКС - 1");
        result7.setValue(76);
        result7.setYear("2011");
        resultRepository.save(result7);

        Result result3 = new Result();
        result3.setSubjectId(subjectId);
        result3.setGroupName("ИС - 60");
        result3.setValue(89);
        result3.setYear("2013");
        resultRepository.save(result3);

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
