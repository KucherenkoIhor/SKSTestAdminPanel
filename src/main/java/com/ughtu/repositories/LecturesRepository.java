package com.ughtu.repositories;

import com.ughtu.models.Lecture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by igor on 28.11.16.
 */
public interface LecturesRepository extends CrudRepository<Lecture, Long> {

    List<Lecture> findBySubjectId(Long subjectId);

    List<Lecture> removeBySubjectId(Long subjectId);

}
