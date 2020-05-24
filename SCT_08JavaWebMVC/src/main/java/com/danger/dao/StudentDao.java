package com.danger.dao;

import com.danger.domain.Course;
import com.danger.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    /**
     * 学生登录
     * @param id
     * @param name
     * @return
     */
    @Select("select * from student where id = #{id} and sname = #{name}")
    Student login(@Param("id")Integer id, @Param("name") String name) throws Exception;

    @Insert("insert into student(id, sname) values(#{id}, #{sname})")
    void save(Student student);

    @Select("select * from student")
    List<Student> findAll();

    @Delete("delete from student where id = #{id}")
    void remove(Integer id);

    @Select("select * from course where id not in( select cid from student_course where sid = #{sid} )")
    List<Course> findOtherCourse(Integer sid);

    @Insert("insert into student_course(sid, cid) values(#{sid}, #{cid})")
    void addCourse(@Param("sid")Integer sid,@Param("cid")Integer cid);

    @Select("select * from course where id in( select cid from student_course where sid = #{sid} )")
    List<Course> findSelectedCourse(Integer sid);

    @Delete("delete from student_course where sid = #{sid} and cid = #{cid}")
    void removeCourse(@Param("sid")Integer sid,@Param("cid") Integer cid);
}
