package com.danger.dao;

import com.danger.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TeacherDao {
    @Select("select * from teacher")
    List<Teacher> findAll();

    @Insert("insert into teacher(tname, password, tsubject, tdate) values(#{tname}, #{password}, #{tsubject}, #{tdate})")
    void add(Teacher teacher);

    @Delete("delete from teacher where id = #{id}")
    void delete(Integer id);

    @Select("select * from teacher where id = #{viewId}")
    Teacher findOne(Integer viewId);
}
