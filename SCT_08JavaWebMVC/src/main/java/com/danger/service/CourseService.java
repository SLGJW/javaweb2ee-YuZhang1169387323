package com.danger.service;

import com.danger.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    void save(Course course);

    void remove(Integer id);

}
