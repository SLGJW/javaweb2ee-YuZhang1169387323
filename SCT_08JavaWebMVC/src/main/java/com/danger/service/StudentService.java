package com.danger.service;


import com.danger.domain.Course;
import com.danger.domain.Student;

import java.util.List;

public interface StudentService {
    Student login(Integer id, String name) throws  Exception;

    void save(Student student);

    List<Student> findAll();

    void remove(Integer id);

    List<Course> findOtherCourse(Integer sid);

    void addCourse(Integer sid, Integer cid);

    List<Course> findSelectedCourse(Integer sid);

    void removeCourse(Integer sid, Integer cid);
}
