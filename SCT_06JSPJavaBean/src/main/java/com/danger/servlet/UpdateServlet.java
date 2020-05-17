package com.danger.servlet;

import com.danger.utils.JDBCUtil;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String id = request.getParameter("id");
        String age = request.getParameter("age");
        int i = Integer.parseInt(id);
        String sql = "update student set username = ?, age = ? where id = ?";
        try {
            PreparedStatement pst = JDBCUtil.getConnection().prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,age);
            pst.setInt(3,i);
            int i1 = pst.executeUpdate();
            if (i1>0){
                request.setAttribute("message","操作成功");
            }else{
                request.setAttribute("message","操作失败");
            }
            request.getRequestDispatcher("/findStudents").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
