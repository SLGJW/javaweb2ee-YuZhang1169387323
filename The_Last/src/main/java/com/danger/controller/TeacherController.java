package com.danger.controller;

import com.danger.domain.Teacher;
import com.danger.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/findOne")
    public ModelAndView findOne(@RequestParam(name = "viewId")Integer viewId){
        ModelAndView mv = new ModelAndView();
        Teacher teacher = teacherService.findOne(viewId);
        mv.addObject("teacher", teacher);
        mv.setViewName("detail");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id", required = true)Integer id){
        teacherService.delete(id);
        return "main";
    }

    @RequestMapping("/add")
    public String add( Teacher teacher){
        teacherService.add(teacher);
        return "main";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Teacher> teachers = teacherService.findAll();
        mv.setViewName("main");
        mv.addObject("teachers", teachers);
        return mv;
    }
}
