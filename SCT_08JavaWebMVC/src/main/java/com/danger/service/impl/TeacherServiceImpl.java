package com.danger.service.impl;

import com.danger.dao.TeacherDao;
import com.danger.domain.Course;
import com.danger.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements com.danger.service.TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher login(int id, String name) throws Exception {
        return teacherDao.login(id, name);
    }

    @Override
    public List<Teacher> findAll() {

        return teacherDao.findAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public void remove(Integer id) {
        teacherDao.remove(id);
    }


    @Override
    public List<Course> findBeginCourse(Integer tid) {
        return teacherDao.findBeginCourse(tid);
    }

    @Override
    public List<Course> findCloseCourse(Integer tid) {
        return teacherDao.findCloseCourse(tid);
    }

    @Override
    public void beginCOurse(Integer tid, Integer cid) {
        teacherDao.beginCourse(tid, cid);
    }

    @Override
    public void closeCourse(Integer tid, Integer cid) {
        teacherDao.closeCourse(tid, cid);
    }
}
