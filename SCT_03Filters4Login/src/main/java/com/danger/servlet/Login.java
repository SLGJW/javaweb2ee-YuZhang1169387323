package com.danger.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if ("admin".equals(account) && "admin".equals(password)){
            //密码正确
            resp.sendRedirect(req.getContextPath() + "success.html");
            //加入用户到会话
            req.getSession().setAttribute("user",account);
        }else{
            //密码错误
            resp.sendRedirect(req.getContextPath() + "error.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
