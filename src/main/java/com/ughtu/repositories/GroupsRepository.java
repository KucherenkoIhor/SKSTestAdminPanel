package com.ughtu.repositories;

import com.ughtu.models.StudentsGroup;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 17.11.16.
 */
public interface GroupsRepository extends CrudRepository<StudentsGroup, Long> {
}
