package com.danger.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if ("".equals(account) || account == null || "".equals(password) || password == null) {
            request.setAttribute("message", "账户或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        if ("admin".equals(account) && "admin".equals(password)) {
            //登录成功
            request.setAttribute("account", account);
            request.getRequestDispatcher("/work.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
