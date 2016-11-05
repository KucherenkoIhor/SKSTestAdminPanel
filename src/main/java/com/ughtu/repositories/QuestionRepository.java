package com.ughtu.repositories;

import com.ughtu.models.Question;
import com.ughtu.models.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by igor on 05.11.16.
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findBySubjectId(Long subjectId);

}
