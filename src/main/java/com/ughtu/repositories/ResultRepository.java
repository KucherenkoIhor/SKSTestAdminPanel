package com.ughtu.repositories;

import com.ughtu.models.Question;
import com.ughtu.models.Result;
import com.ughtu.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by igor on 17.11.16.
 */
public interface ResultRepository extends CrudRepository<Result, Long> {

    List<Result> findBySubjectId(Long subjectId);

}
