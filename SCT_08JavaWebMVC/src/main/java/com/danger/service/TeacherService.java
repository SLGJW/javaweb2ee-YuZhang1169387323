package com.danger.service;

import com.danger.domain.Course;
import com.danger.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher login(int id, String name) throws Exception;

    List<Teacher> findAll();

    void save(Teacher teacher);

    void remove(Integer id);

    List<Course> findBeginCourse(Integer tid);

    List<Course> findCloseCourse(Integer tid);

    void beginCOurse(Integer tid, Integer cid);

    void closeCourse(Integer tid, Integer cid);
}
