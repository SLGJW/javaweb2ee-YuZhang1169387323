package com.danger.dao;

import com.danger.domain.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    @Select("select * from course")
    List<Course> findAll();

    @Insert("insert into course(id, cname) values(#{id}, #{cname})")
    void save(Course course);

    @Delete("delete from course where id = #{id}")
    void remove(Integer id);
}
