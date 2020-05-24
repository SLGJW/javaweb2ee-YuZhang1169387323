package com.danger.dao;

import com.danger.domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 添加学生
     * @param student
     */
    int addStudent(Student student) throws Exception;

    /**
     * 删除学生
     * @param id
     */
    int deleteStudent(Integer id)throws Exception;

    /**
     * 更新学生信息
     * @param id
     */
    int updateStudent(Student student)throws Exception;

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> findAll()throws Exception;
}
