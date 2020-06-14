package com.danger.controller;

import com.danger.domain.Adminuser;
import com.danger.service.AdminuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminuserController {

    @Autowired
    private AdminuserService adminuserService;

    @RequestMapping("/login")
    public void login(@RequestParam(name = "username", required = true)String username, @RequestParam(name = "password", required = true)String password, @RequestParam(name = "checkCode", required = true)String checkCode, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session中的验证码
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //获取输入的验证码
        // 比较
        if (checkcode_server.equalsIgnoreCase(checkCode)){
            //验证码正确
            Adminuser adminuser = adminuserService.findOne(username, password);
            if (adminuser != null){
                request.getSession().setAttribute("username",adminuser.getUsername());
                response.sendRedirect(request.getContextPath() + "/pages//main.jsp");
            }else{
                request.setAttribute("errorMsg", "用户名或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("errorMsg", "验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }


    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "hahhahahaha";
    }
}
