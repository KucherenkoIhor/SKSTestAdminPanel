package com.ughtu.controllers;

import com.ughtu.models.Question;
import com.ughtu.models.Subject;
import com.ughtu.repositories.AnswerRepository;
import com.ughtu.repositories.LecturesRepository;
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
    @Autowired
    private LecturesRepository lecturesRepository;

    private Long lectureId = 0L;

    @RequestMapping("/tests/{lectureId}")
    public String testByLectureId(Model model, @PathVariable Long lectureId) {
        this.lectureId = lectureId;
        long subjectId = lecturesRepository.findOne(lectureId).getSubjectId();
        model.addAttribute("subject", subjectId);
        model.addAttribute("question", new Question());
        model.addAttribute("questions", questionRepository.findByLectureId(lectureId));
        return "tests";
    }

    @RequestMapping(value = "/tests", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute Question question) {
        question.setLectureId(lectureId);
        questionRepository.save(question);
        return "redirect:/tests/" + lectureId;
    }

    @Transactional
    @RequestMapping("/tests/delete/{id}")
    public String delete(@PathVariable Long id){
        questionRepository.delete(id);
        answerRepository.removeByQuestionId(id);
        return "redirect:/tests/" + lectureId;
    }

}
