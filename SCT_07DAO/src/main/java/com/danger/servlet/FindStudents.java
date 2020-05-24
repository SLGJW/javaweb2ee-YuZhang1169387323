package com.danger.servlet;

import com.danger.dao.StudentDao;
import com.danger.dao.impl.StudentDaoImpl;
import com.danger.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudents")
public class FindStudents extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = null;
        try {
            students = studentDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("list", students);
        request.getRequestDispatcher("/work.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
