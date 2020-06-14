package com.danger.service.impl;

import com.danger.dao.TeacherDao;
import com.danger.domain.Teacher;
import com.danger.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        teacherDao.add(teacher);
    }

    @Override
    public void delete(Integer id) {
        teacherDao.delete(id);
    }

    @Override
    public Teacher findOne(Integer viewId) {
        return teacherDao.findOne(viewId);
    }
}
