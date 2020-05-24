package com.danger.dao;

import com.danger.domain.Course;
import com.danger.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {

    /**
     * 教师登录
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @Select("select * from teacher where id = #{id} and tname = #{name}")
    Teacher login(@Param("id")Integer id, @Param("name") String name) throws Exception;

    @Select("select * from teacher")
    List<Teacher> findAll();

    @Insert("insert into teacher(id, tname) values(#{id}, #{tname})")
    void save(Teacher teacher);

    @Delete("delete from teacher where id = #{id}")
    void remove(Integer id);

    @Select("select * from course where id in (select cid from teacher_course where tid = #{tid})")
    List<Course> findBeginCourse(Integer tid);

    @Select("select * from course where id not in (select cid from teacher_course where tid = #{tid})")
    List<Course> findCloseCourse(Integer tid);

    @Insert("insert into teacher_course(tid, cid) values(#{tid}, #{cid})")
    void beginCourse(@Param("tid")Integer tid, @Param("cid")Integer cid);

    @Delete("delete from teacher_course where tid = #{tid} and cid = #{cid}")
    void closeCourse(@Param("tid")Integer tid, @Param("cid")Integer cid);

}
