package com.danger.service.impl;

import com.danger.dao.StudentDao;
import com.danger.domain.Student;
import com.danger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }

    @Override
    public Student findOne(Integer viewId) {
        return studentDao.findOne(viewId);
    }

    @Override
    public void update(String newPassword, Integer id) {
        studentDao.update(newPassword, id);
    }
}
