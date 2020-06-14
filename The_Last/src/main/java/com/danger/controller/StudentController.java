package com.danger.controller;

import com.danger.domain.Student;
import com.danger.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/update")
    public String update(@RequestParam(name = "newPassword", required = true)String newPassword, @RequestParam(name = "id", required = true)Integer id){
        studentService.update(newPassword, id);
        return "main";
    }

    @RequestMapping("/findOne")
    public ModelAndView findOne(@RequestParam(name = "viewId")Integer viewId){
        ModelAndView mv = new ModelAndView();
        Student student = studentService.findOne(viewId);
        mv.addObject("student", student);
        mv.setViewName("detail");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id", required = true)Integer id){
        studentService.delete(id);
        return "main";
    }

    @RequestMapping("/add")
    public String add( Student student){
        studentService.add(student);
        return "main";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Student> students = studentService.findAll();
        mv.setViewName("main");
        mv.addObject("students", students);
        return mv;
    }
}
