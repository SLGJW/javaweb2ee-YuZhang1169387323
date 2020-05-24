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

/**
 * 添加学生
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        if (username != "" && username != null && age != "" && age != null) {
            Student student = new Student();
            student.setUsername(username);
            student.setAge(age);
            int i = 0;
            try {
                i = studentDao.addStudent(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i > 0) {
                request.setAttribute("message", "操作成功");
            } else {
                request.setAttribute("message", "操作失败");
            }
            request.getRequestDispatcher("work.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
