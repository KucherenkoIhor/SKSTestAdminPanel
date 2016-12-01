package com.ughtu.controllers.api;

import com.ughtu.models.Lecture;
import com.ughtu.models.StudentsGroup;
import com.ughtu.models.Subject;
import com.ughtu.repositories.GroupsRepository;
import com.ughtu.repositories.LecturesRepository;
import com.ughtu.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 25.11.16.
 */
@Controller
public class ApiController {

    @Autowired
    private GroupsRepository mGroupsRepository;
    @Autowired
    private SubjectRepository mSubjectRepository;
    @Autowired
    private LecturesRepository mLecturesRepository;

    @RequestMapping(
            path = "/api/groups",
            method =  RequestMethod.GET)
    public @ResponseBody List<StudentsGroup> getGroups() {
        List<StudentsGroup> result = new ArrayList<>();
        try {
            mGroupsRepository.findAll().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(
            path = "/api/subjects",
            method =  RequestMethod.GET)
    public @ResponseBody List<Subject> getSubjects() {
        List<Subject> result = new ArrayList<>();
        try {
            mSubjectRepository.findAll().forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(
            path = "/api/lectures",
            method =  RequestMethod.GET)
    public @ResponseBody List<Lecture> getLectures(@RequestParam(value="subjectId") Long subjectId) {
        List<Lecture> result = new ArrayList<>();
        try {
            mLecturesRepository.findBySubjectId(subjectId).forEach(result::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
