package com.czh.controller;

import com.czh.pojo.User;
import com.czh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
//告诉spring mvc这是一个控制器类
//处理http请求
@RequestMapping("")
//配置url映射
public class UserController {
    Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    @Autowired
    UserService userService;
    //IOC方式获取一个对象

    @ResponseBody
    @RequestMapping(value = "/a/u/user", method = RequestMethod.POST)
    public Map insert(User user) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = userService.insert(user);
        if (a == 1) {
            map.put("code", 200);
            map.put("message", "添加成功");
        } else {
            map.put("code", 400);
            map.put("message", "添加失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.DELETE)
    public Map deleteUser(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = userService.deleteByPrimaryKey(id);
        if (a) {
            map.put("code", 200);
            map.put("message", "删除成功");
        } else {
            map.put("code", 400);
            map.put("message", "删除失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.PUT)
    public Map updateUser(@PathVariable Long id, User user) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = userService.updateByPrimaryKey(user);
        if (a) {
            map.put("code", 200);
            map.put("message", "编辑成功");
        } else {
            map.put("code", 400);
            map.put("message", "编辑失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/u/user", method = RequestMethod.GET)
    public Map getUser(@RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "role", required = false) String role) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<User> users = userService.getUser(username, role);
        if (users == null || users.size() == 0) {
            map.put("code", 400);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询成功");
            map.put("data", users);
        }
        logger.info(":查询结果" + users);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/user{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, User user) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        user = userService.selectByPrimaryKey(id);
        if (user == null) {
            map.put("code", 400);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询单条数据成功");
            map.put("data", user);
        }
        logger.info(":查询结果" + user);
        return map;
    }
}
