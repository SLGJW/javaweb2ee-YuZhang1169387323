package com.danger.controller;

import com.danger.domain.Course;
import com.danger.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll.action")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Course> courseList = courseService.findAll();
        mv.addObject("courseList", courseList);
        mv.setViewName("main");
        return mv;
    }

    /**
     * 添加学生
     *
     * @param course
     * @return
     */
    @RequestMapping("/save.action")
    public String save(Course course) {
        courseService.save(course);
        return "redirect:findALl.action";
    }

    /**
     * 移除课程
     *
     * @param id
     * @return
     */
    @RequestMapping("/remove.action")
    public String remove(@RequestParam(name = "id", required = true) Integer id) {
        courseService.remove(id);
        return "redirect:findAll.action";
    }
}
