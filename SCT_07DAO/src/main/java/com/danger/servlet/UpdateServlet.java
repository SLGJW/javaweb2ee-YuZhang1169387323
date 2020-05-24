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

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String id = request.getParameter("id");
        String age = request.getParameter("age");
        int i = Integer.parseInt(id);
        Student student = new Student();
        student.setAge(age);
        student.setUsername(username);
        student.setId(i);
        int result = 0;
        try {
            result = studentDao.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0) {
            request.setAttribute("message", "操作成功");
        } else {
            request.setAttribute("message", "操作失败");
        }
        request.getRequestDispatcher("/findStudents").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
