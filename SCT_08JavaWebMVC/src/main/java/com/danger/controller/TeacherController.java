package com.danger.controller;

import com.danger.domain.Course;
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
    private TeacherService teacherService;

    /**
     * 关闭课程
     * @param tid
     * @param cid
     * @return
     */
    @RequestMapping("/closeCourse.action")
    public String closeCourse(@RequestParam(name = "tid", required = true) Integer tid, @RequestParam(name = "cid", required = true) Integer cid) {
        teacherService.closeCourse(tid, cid);
        return "redirect:findCloseCourse.action?tid=" + tid;
    }

    /**
     * 开设课程
     *
     * @param tid
     * @param cid
     * @return
     */
    @RequestMapping("/beginCourse.action")
    public String beginCourse(@RequestParam(name = "tid", required = true) Integer tid, @RequestParam(name = "cid", required = true) Integer cid) {
        teacherService.beginCOurse(tid, cid);
        return "redirect:findBeginCourse.action?tid=" + tid;
    }


    /**
     * 查询开设课程信息
     *
     * @param tid
     * @return
     */
    @RequestMapping("/findBeginCourse.action")
    public ModelAndView findBeginCourse(@RequestParam(name = "tid", required = true) Integer tid) {
        ModelAndView mv = new ModelAndView();
        List<Course> beginList = teacherService.findBeginCourse(tid);
        mv.addObject("beginList", beginList);
        mv.setViewName("teacher");
        return mv;
    }

    /**
     * 查询未开设课程信息
     *
     * @param tid
     * @return
     */
    @RequestMapping("/findCloseCourse.action")
    public ModelAndView findCloseCourse(@RequestParam(name = "tid", required = true) Integer tid) {
        ModelAndView mv = new ModelAndView();
        List<Course> closeList = teacherService.findCloseCourse(tid);
        mv.addObject("closeList", closeList);
        mv.setViewName("teacher");
        return mv;
    }

    /**
     * 查看所有教师信息
     *
     * @return
     */
    @RequestMapping("/findAll.action")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Teacher> teacherList = teacherService.findAll();
        mv.addObject("teacherList", teacherList);
        mv.setViewName("main");
        return mv;
    }

    /**
     * 添加教师
     *
     * @param teacher
     * @return
     */
    @RequestMapping("/save.action")
    public String save(Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:findALl.action";
    }

    /**
     * 移除教师
     *
     * @param id
     * @return
     */
    @RequestMapping("/remove.action")
    public String remove(@RequestParam(name = "id", required = true) Integer id) {
        teacherService.remove(id);
        return "redirect:findAll.action";
    }
}
