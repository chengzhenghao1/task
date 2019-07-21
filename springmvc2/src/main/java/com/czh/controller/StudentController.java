package com.czh.controller;

import com.czh.pojo.Student;
import com.czh.service.StudentService;
import com.czh.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
//告诉spring mvc这是一个控制器类
//处理http请求
@RequestMapping("")
//配置url映射
public class StudentController {
    Logger logger = Logger.getLogger(String.valueOf(StudentController.class));

    @Autowired
    StudentService studentService;
    //IOC方式获取一个对象

    @RequestMapping(value = "/listStudent", method = RequestMethod.GET)
    public ModelAndView listStudent(Page page) {
        //接受分页信息的注入
        ModelAndView mav = new ModelAndView();
        List<Student> cs = studentService.list(page);
        //根据分页对象，获取对象集合cs
        int total = studentService.total();
        //调用total方法
        page.caculateLast(total);
        //根据总数计算出最后一页的信息
        mav.addObject("cs", cs);
        //放入转发参数
        mav.setViewName("listStudent");
        //放入jsp路径
        return mav;
    }


    @RequestMapping(value = "/increaseStudent", method = RequestMethod.GET)
    public String addStudent() {
        return "increaseStudent";
    }

    @RequestMapping(value = "/increaseStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) {
        //声明使用接口方法，IOC方式获取一个对象
        logger.info("进入增加方法");
        studentService.add(student);
        //调用服务层接口方法
        ModelAndView mav = new ModelAndView("redirect:/listStudent");
        //代表MVC Web程序中的对象，方便一次返回二个对象
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable int id) {
        logger.info("进入删除方法");
        studentService.delete(id);
        ModelAndView mav = new ModelAndView("redirect:/listStudent");
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) {
        Student student = studentService.get(id);
        ModelAndView mav = new ModelAndView("editStudent");
        mav.addObject("student", student);
        logger.info(String.valueOf(student));
        return mav;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ModelAndView update(Student student) {
        logger.info("进入编辑");
        studentService.update(student);
        ModelAndView mav = new ModelAndView("redirect:/listStudent");
        return mav;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("redirect:/listStudent");
        return mav;
    }

    @RequestMapping(value = "/student/name/", method = RequestMethod.GET)
    public ModelAndView findByName(@RequestParam String name) {
        logger.info("进入模糊方法");
        List<Student> cs = studentService.findByName(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("cs", cs);
        mav.setViewName("dimStudent");
        return mav;
    }

    @ResponseBody
    //利用spring mvc的注解@ResponseBody
    @RequestMapping(value = "/json", produces = "application/json; charset=utf-8")
    public List json(Page page) {
        List<Student> students = studentService.list(page);
        return students;
    }

    @RequestMapping(value = "/Student", method = RequestMethod.POST)
    public void add(@RequestBody @Valid Student student) {
        logger.info(student.toString());
    }
}
