package com.ughtu.controllers;

import com.ughtu.models.Lecture;
import com.ughtu.models.Question;
import com.ughtu.repositories.AnswerRepository;
import com.ughtu.repositories.LecturesRepository;
import com.ughtu.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by igor on 28.11.16.
 */
@Controller
public class LecturesController {

    @Autowired
    private LecturesRepository lecturesRepository;
    @Autowired
    private QuestionRepository questionsRepository;
    @Autowired
    private AnswerRepository answersRepository;

    private Long subjectId = 0L;

    @RequestMapping("/lectures/{subjectId}")
    public String testBySubjectId(Model model, @PathVariable Long subjectId) {
        this.subjectId = subjectId;
        model.addAttribute("lecture", new Lecture());
        model.addAttribute("lectures", lecturesRepository.findBySubjectId(subjectId));
        return "lectures";
    }

    @RequestMapping(value = "/lectures", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute Lecture lecture) {
        lecture.setSubjectId(subjectId);
        lecturesRepository.save(lecture);
        return "redirect:/lectures/" + subjectId;
    }

    @Transactional
    @RequestMapping("/lectures/delete/{id}")
    public String delete(@PathVariable Long id){
        lecturesRepository.delete(id);
        List<Question> questions = questionsRepository.removeByLectureId(id);
        questions.forEach(question -> {
            answersRepository.findByQuestionId(question.getId());
        });
        return "redirect:/lectures/" + subjectId;
    }

}
