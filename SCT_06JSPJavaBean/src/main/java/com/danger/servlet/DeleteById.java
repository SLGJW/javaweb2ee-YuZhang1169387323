package com.danger.servlet;

import com.danger.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteById")
public class DeleteById extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from student where id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,i);
            int i1 = pst.executeUpdate();
            if (i1 > 0) {
                request.setAttribute("message", "删除成功");
            } else {
                request.setAttribute("message", "删除失败");
            }
            JDBCUtil.close(conn, pst);
            request.getRequestDispatcher("/findStudents").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
