package com.danger.controller;

import com.danger.domain.Course;
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

    @RequestMapping("/removeCourse.action")
    public String removeCourse(@RequestParam(name = "sid", required = true)Integer sid, @RequestParam(name = "cid", required = true)Integer cid){
        studentService.removeCourse(sid, cid);
        return "redirect:findOtherCourse.action?sid=" + sid;
    }

    @RequestMapping("/findSelectedCourse.action")
    public ModelAndView findSelectedCourse(@RequestParam(name = "sid", required = true)Integer sid){
        ModelAndView mv = new ModelAndView();
        List<Course> selectList = studentService.findSelectedCourse(sid);
        mv.addObject("selectList", selectList);
        mv.setViewName("student");
        return mv;
    }

    /**
     * 添加选课
     * @param sid
     * @param cid
     * @return
     */
    @RequestMapping("/addCourse.action")
    public String addCourse(@RequestParam(name = "sid", required = true)Integer sid, @RequestParam(name = "cid", required = true)Integer cid){
        studentService.addCourse(sid, cid);
        return "redirect:findSelectedCourse.action?sid=" + sid;
    }

    /**
     * 查询未选择的课程
     * @param sid
     * @return
     */
    @RequestMapping("/findOtherCourse.action")
    public ModelAndView findOtherCourse(@RequestParam(name = "sid", required = true)Integer sid){
        ModelAndView mv = new ModelAndView();
        List<Course> otherList =  studentService.findOtherCourse(sid);
        mv.addObject("otherList", otherList);
        mv.setViewName("student");
        return mv;
    }

    @RequestMapping("/findAll.action")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Student> studentList = studentService.findAll();
        mv.addObject("studentList", studentList);
        mv.setViewName("main");
        return mv;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/save.action")
    public String save(Student student){
        studentService.save(student);
        return "redirect:findALl.action";
    }


    /**
     * 移除学生
     * @param id
     * @return
     */
    @RequestMapping("/remove.action")
    public String remove(@RequestParam(name = "id", required = true) Integer id) {
        studentService.remove(id);
        return "redirect:findAll.action";
    }
}
