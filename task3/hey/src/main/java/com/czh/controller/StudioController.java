package com.czh.controller;

import com.czh.pojo.Studio;
import com.czh.service.StudioService;
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
public class StudioController {
    Logger logger = Logger.getLogger(String.valueOf(StudioController.class));

    @Autowired
    StudioService studioService;

    @ResponseBody
    @RequestMapping(value = "/a/u/studio", method = RequestMethod.POST)
    public Map insert(Studio studio) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = studioService.insert(studio);
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
    @RequestMapping(value = "/a/u/studio/{id}", method = RequestMethod.DELETE)
    public Map deleteStudio(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = studioService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/studio/{id}", method = RequestMethod.PUT)
    public Map updateStudio(@PathVariable Long id, Studio studio) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = studioService.updateByPrimaryKey(studio);
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
    @RequestMapping(value = "/a/u/studio", method = RequestMethod.GET)
    public Map getStudio(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "state", required = false) long state) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Studio> studios = studioService.getStudio(name, state);
        if (studios == null || studios.size() == 0) {
            map.put("code", 200);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询成功");
            map.put("data", studios);
        }
        logger.info(":查询结果" + studios);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/studio{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Studio studio) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        studio = studioService.selectByPrimaryKey(id);
        if (studio == null) {
            map.put("code", 200);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询单条数据成功");
            map.put("data", studio);
        }
        logger.info(":查询结果" + studio);
        return map;
    }
}
