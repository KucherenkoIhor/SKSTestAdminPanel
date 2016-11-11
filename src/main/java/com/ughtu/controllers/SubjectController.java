package com.ughtu.controllers;

import com.ughtu.models.Question;
import com.ughtu.models.Subject;
import com.ughtu.repositories.AnswerRepository;
import com.ughtu.repositories.QuestionRepository;
import com.ughtu.repositories.SubjectRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by igor on 25.10.16.
 */
@Controller
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

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

    @Transactional
    @RequestMapping("/subject/delete/{id}")
    public String delete(@PathVariable Long id){
        subjectRepository.delete(id);
        List<Question> questions = questionRepository.removeBySubjectId(id);
        for (Question question : questions) {
            answerRepository.removeByQuestionId(question.getId());
        }
        return "redirect:/subject";
    }

}
