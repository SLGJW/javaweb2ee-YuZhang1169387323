package com.danger.servlet;

import com.danger.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 添加学生
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        if (username != "" && username!= null && age != "" && age != null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = JDBCUtil.getConnection();
                String sql = "insert into student(username, age) values(?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,username);
                pst.setString(2,age);
                int i = pst.executeUpdate();
                if (i>0){
                    request.setAttribute("message","操作成功");
                }else{
                    request.setAttribute("message","操作失败");
                }
                //释放资源
                JDBCUtil.close(conn, pst);
                request.getRequestDispatcher("work.jsp").forward(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
