package com.danger.dao.impl;

import com.danger.dao.StudentDao;
import com.danger.domain.Student;
import com.danger.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int addStudent(Student student) throws Exception {
        //获取连接
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        String sql = "insert into student(username, age) values(?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, student.getUsername());
        pst.setString(2, student.getAge());
        int i = pst.executeUpdate();
        //释放资源
        JDBCUtil.close(conn, pst);
        return i;
    }

    @Override
    public int deleteStudent(Integer id) throws Exception {
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,id);
        int result = pst.executeUpdate();
        JDBCUtil.close(conn, pst);
        return result;
    }

    @Override
    public int updateStudent(Student student) throws Exception {
        String sql = "update student set username = ?, age = ? where id = ?";
        PreparedStatement pst = JDBCUtil.getConnection().prepareStatement(sql);
        pst.setString(1, student.getUsername());
        pst.setString(2, student.getAge());
        pst.setInt(3, student.getId());
        int result = pst.executeUpdate();
        JDBCUtil.close(null,pst);
        return result;
    }

    @Override
    public List<Student> findAll() throws Exception {
        String sql = "select * from student";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUsername(rs.getString("username"));
            student.setAge(rs.getString("age"));
            students.add(student);
        }
        JDBCUtil.close(conn, pst, rs);
        return students;
    }
}


