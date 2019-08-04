package com.czh.controller;

import com.czh.pojo.Second;
import com.czh.service.SecondService;
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
public class SecondController {
    Logger logger = Logger.getLogger(String.valueOf(SecondController.class));

    @Autowired
    SecondService secondService;

    @ResponseBody
    @RequestMapping(value = "/a/u/second", method = RequestMethod.POST)
    public Map insert(Second second) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = secondService.insert(second);
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
    @RequestMapping(value = "/a/u/second/{id}", method = RequestMethod.DELETE)
    public Map deleteSecond(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = secondService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/second/{id}", method = RequestMethod.PUT)
    public Map updateSecond(@PathVariable Long id, Second second) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = secondService.updateByPrimaryKey(second);
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
    @RequestMapping(value = "/a/u/second", method = RequestMethod.GET)
    public Map getAnswering(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "state", required = false) long state) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Second> seconds = secondService.getSecond(name, state);
        if (seconds == null || seconds.size() == 0) {
            map.put("code", 200);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询成功");
            map.put("data", seconds);
        }
        logger.info(":查询结果" + seconds);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/second{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Second second) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        second = secondService.selectByPrimaryKey(id);
        if (second == null) {
            map.put("code", 200);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询单条数据成功");
            map.put("data", second);
        }
        logger.info(":查询结果" + second);
        return map;
    }
}
