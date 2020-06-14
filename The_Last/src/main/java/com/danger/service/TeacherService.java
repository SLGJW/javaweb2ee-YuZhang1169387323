package com.danger.service;

import com.danger.domain.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findAll();

    void add(Teacher teacher);

    void delete(Integer id);

    Teacher findOne(Integer viewId);
}
