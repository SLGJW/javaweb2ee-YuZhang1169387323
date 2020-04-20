package com.danger.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Session
 */
@WebServlet("/loginSession")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取session
        HttpSession session = request.getSession();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //获取服务器的session
        String user = (String) session.getAttribute("user");
        if (user != null && user != "" && "admin".equals(user)) {
            //不是首次登录
            session.setAttribute("sessionInfo", "欢迎您再次登录");
        }
        if (user == null || user == "") {
            //首次登录
            if (("admin").equals(account) && ("admin").equals(password)) {
                session.setAttribute("user", account);
                session.setAttribute("sessionInfo", "欢迎您");
            } else {
                //回写信息
                session.setAttribute("loginInfo", "账户或密码错误");
                response.sendRedirect("/login.jsp");
            }
        }
        response.sendRedirect("/success.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
