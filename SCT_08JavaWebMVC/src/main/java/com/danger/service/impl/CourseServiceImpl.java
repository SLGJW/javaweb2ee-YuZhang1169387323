package com.danger.service.impl;

import com.danger.dao.CourseDao;
import com.danger.domain.Course;
import com.danger.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public void remove(Integer id) {
        courseDao.remove(id);
    }
}
