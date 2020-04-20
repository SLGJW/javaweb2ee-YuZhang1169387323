package com.tiger.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        boolean flag = false;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("account".equals(cookie.getName())) {
                flag = true;
                //不是首次登录
                request.setAttribute("cookieInfo", "欢迎您再次登录");
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            }
            if (cookies == null || flag == false) {
                //首次登录
                if (("admin").equals(account) && ("admin").equals(password)) {
                    Cookie cook = new Cookie("account", account);
                    cook.setMaxAge(60 * 60 * 24);
                    cook.setPath("/");
                    response.addCookie(cook);
                    request.setAttribute("cookieInfo", "欢迎您");
                    request.getRequestDispatcher("/success.jsp").forward(request, response);
                } else {
                    //回写信息
                    request.setAttribute("loginInfo", "账户或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
