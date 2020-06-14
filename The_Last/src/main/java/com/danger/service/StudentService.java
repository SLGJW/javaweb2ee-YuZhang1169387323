package com.danger.service;

import com.danger.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    void add(Student student);

    void delete(Integer id);

    Student findOne(Integer viewId);

    void update(String newPassword, Integer id);
}
