package com.danger.servlet;

import com.danger.domain.Student;
import com.danger.utils.JDBCUtil;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findStudents")
public class FindStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from student";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setAge(rs.getString("age"));
                students.add(student);
            }
            JDBCUtil.close(conn, pst, rs);
            request.setAttribute("list", students);
            request.getRequestDispatcher("/work.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
