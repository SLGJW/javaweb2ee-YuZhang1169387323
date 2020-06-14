package com.danger.dao;

import com.danger.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentDao {


    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into student(sname, password, sdept, sdate) values(#{sname}, #{password}, #{sdept}, #{sdate})")
    void add(Student student);

    @Delete("delete from student where id = #{id}")
    void delete(Integer id);

    @Select("select * from student where id = #{viewId}")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "sname", property = "sname"),
        @Result(column = "password", property = "password"),
        @Result(column = "sdate", property = "sdate"),
        @Result(column = "sdept", property = "sdept"),
        @Result(column = "id", property = "courses", javaType =java.util.List.class, many = @Many(select = "com.danger.dao.CourseDao.findBySid"))
    })
    Student findOne(Integer viewId);

    @Update("update student set password = #{newPassword} where id = #{id}")
    void update(@Param("newPassword")String newPassword, @Param("id") Integer id);
}
