package com.danger.controller;

import com.danger.domain.Course;
import com.danger.domain.Student;
import com.danger.domain.Teacher;
import com.danger.service.CourseService;
import com.danger.service.StudentService;
import com.danger.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/save.action")
    public String save(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "status", required = true) Integer status) {
        if (status == 1) {
            //学生
            Student student = new Student();
            student.setSname(name);
            studentService.save(student);
        } else if (status == 2) {
            //老师
            Teacher teacher = new Teacher();
            teacher.setTname(name);
            teacherService.save(teacher);
        }else if (status == 3){
            //课程
            Course course = new Course();
            course.setCname(name);
            courseService.save(course);
        }
        return "main";
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping("/login.action")
    public ModelAndView userLogin(@RequestParam(name = "id", required = true) Integer id, @RequestParam(name = "name", required = true) String name, @RequestParam(name = "status", required = true) String status, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        if ("3".equals(status)) {
            //管理员界面
            if (id == 001 && "admin".equals(name)) {
                mv.addObject("name", name);
                request.getSession().setAttribute("name", name);
                mv.setViewName("main");
                return mv;
            }
        } else if ("2".equals(status)) {
            //老师
            Teacher teacher = teacherService.login(id, name);
            if (teacher != null) {
                mv.addObject("teacher", teacher);
                request.getSession().setAttribute("teacher", teacher);
                mv.setViewName("teacher");
                return mv;
            }

        } else if ("1".equals(status)) {
            //学生
            Student student = studentService.login(id, name);
            if (student != null) {
                mv.addObject("student", student);
                request.getSession().setAttribute("student", student);
                mv.setViewName("student");
                return mv;
            }

        }
        mv.addObject("message", "账户或者密码错误");
        mv.setViewName("error");
        return mv;
    }
}
