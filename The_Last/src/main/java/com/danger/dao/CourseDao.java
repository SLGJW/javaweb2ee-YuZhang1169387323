package com.danger.dao;

import com.danger.domain.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CourseDao {

    @Select("select * from course where id in (select cid from student_course where sid = #{id})")
    List<Course> findBySid();
}
