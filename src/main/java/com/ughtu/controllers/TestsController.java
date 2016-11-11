package com.ughtu.controllers;

import com.ughtu.models.Question;
import com.ughtu.models.Subject;
import com.ughtu.repositories.AnswerRepository;
import com.ughtu.repositories.QuestionRepository;
import com.ughtu.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by igor on 05.11.16.
 */
@Controller
public class TestsController  {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    private Long subjectId = 0L;

    @RequestMapping("/tests/{subjectId}")
    public String testBySubjectId(Model model, @PathVariable Long subjectId) {
        this.subjectId = subjectId;
        model.addAttribute("question", new Question());
        model.addAttribute("questions", questionRepository.findBySubjectId(subjectId));
        return "tests";
    }

    @RequestMapping(value = "/tests", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute Question question) {
        question.setSubjectId(subjectId);
        questionRepository.save(question);
        return "redirect:/tests/" + subjectId;
    }

    @Transactional
    @RequestMapping("/tests/delete/{id}")
    public String delete(@PathVariable Long id){
        questionRepository.delete(id);
        answerRepository.removeByQuestionId(id);
        return "redirect:/tests/" + subjectId;
    }


}
