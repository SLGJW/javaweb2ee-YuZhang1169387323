package com.danger.servlet;

import com.danger.dao.StudentDao;
import com.danger.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteById")
public class DeleteById extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        try {
            int result = studentDao.deleteStudent(i);
            if (result > 0) {
                request.setAttribute("message", "删除成功");
            } else {
                request.setAttribute("message", "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("/findStudents").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
