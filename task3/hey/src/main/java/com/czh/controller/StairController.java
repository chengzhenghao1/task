package com.czh.controller;

import com.czh.pojo.Stair;
import com.czh.service.StairService;
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
public class StairController {
    Logger logger = Logger.getLogger(String.valueOf(StairController.class));

    @Autowired
    StairService stairService;

    @ResponseBody
    @RequestMapping(value = "/a/u/stair", method = RequestMethod.POST)
    public Map insert(Stair stair) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = stairService.insert(stair);
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
    @RequestMapping(value = "/a/u/stair/{id}", method = RequestMethod.DELETE)
    public Map deleteStair(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = stairService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/stair/{id}", method = RequestMethod.PUT)
    public Map updateStair(@PathVariable Long id, Stair stair) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = stairService.updateByPrimaryKey(stair);
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
    @RequestMapping(value = "/a/u/stair", method = RequestMethod.GET)
    public Map getAnswering(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "state", required = false) long state) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Stair> stairs = stairService.getStair(name, state);
        if (stairs == null || stairs.size() == 0) {
            map.put("code", 200);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询成功");
            map.put("data", stairs);
        }
        logger.info(":查询结果" + stairs);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/stair{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Stair stair) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        stair = stairService.selectByPrimaryKey(id);
        if (stair == null) {
            map.put("code", 200);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询单条数据成功");
            map.put("data", stair);
        }
        logger.info(":查询结果" + stair);
        return map;
    }
}
