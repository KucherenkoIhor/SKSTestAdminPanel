package com.ughtu.repositories;

import com.ughtu.models.Answer;
import com.ughtu.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by polyakov on 11.11.16.
 */
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    List<Answer> removeByQuestionId(Long questionId);

    List<Answer> findByQuestionId(Long questionId);

}
