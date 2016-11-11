package com.ughtu.controllers;


import com.ughtu.models.Answer;
import com.ughtu.models.Question;
import com.ughtu.models.Subject;
import com.ughtu.repositories.AnswerRepository;
import com.ughtu.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AnswersController {

    @Autowired
    private AnswerRepository answerRepository;

    private Long questionId = 0L;

    @RequestMapping("/answers/{questionId}")
    public String answersByQuestionId(Model model, @PathVariable Long questionId) {
        this.questionId = questionId;
        model.addAttribute("answer", new Answer());
        model.addAttribute("answers", answerRepository.findByQuestionId(questionId));
        return "answers";
    }

    @RequestMapping(value = "/answers/add/correct", method = RequestMethod.POST)
    public String saveCorrectAnswer(@ModelAttribute Answer answer) {
        answer.setIsCorrect(true);
        answer.setQuestionId(questionId);
        answerRepository.save(answer);
        return "redirect:/answers/" + questionId;
    }

    @RequestMapping(value = "/answers/add/incorrect", method = RequestMethod.POST)
    public String saveIncorrectAnswer(@ModelAttribute Answer answer) {
        answer.setIsCorrect(false);
        answer.setQuestionId(questionId);
        answerRepository.save(answer);
        return "redirect:/answers/" + questionId;
    }

    @RequestMapping("/answers/delete/{id}")
    public String delete(@PathVariable Long id){
        answerRepository.delete(id);
        return "redirect:/answers/" + questionId;
    }


}
