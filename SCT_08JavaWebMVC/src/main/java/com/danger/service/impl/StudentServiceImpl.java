package com.danger.service.impl;

import com.danger.dao.StudentDao;
import com.danger.domain.Course;
import com.danger.domain.Student;
import com.danger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student login(Integer id, String name) throws Exception{
        return studentDao.login(id, name);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void remove(Integer id) {
        studentDao.remove(id);
    }

    @Override
    public List<Course> findOtherCourse(Integer sid) {

        return studentDao.findOtherCourse(sid);
    }

    @Override
    public void addCourse(Integer sid, Integer cid) {
        studentDao.addCourse(sid, cid);
    }

    @Override
    public List<Course> findSelectedCourse(Integer sid) {
        return studentDao.findSelectedCourse(sid);
    }

    @Override
    public void removeCourse(Integer sid, Integer cid) {
        studentDao.removeCourse(sid,cid);
    }
}
