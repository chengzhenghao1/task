package com.czh.controller;

import com.czh.pojo.Production;
import com.czh.service.ProductionService;
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
public class ProductionController {
    Logger logger = Logger.getLogger(String.valueOf(ProductionController.class));

    @Autowired
    ProductionService productionService;

    @ResponseBody
    @RequestMapping(value = "/a/u/production", method = RequestMethod.POST)
    public Map insert(Production production) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = productionService.insert(production);
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
    @RequestMapping(value = "/a/u/production/{id}", method = RequestMethod.DELETE)
    public Map deleteProduction(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = productionService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/production/{id}", method = RequestMethod.PUT)
    public Map updateProduction(@PathVariable Long id, Production production) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = productionService.updateByPrimaryKey(production);
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
    @RequestMapping(value = "/a/u/production", method = RequestMethod.GET)
    public Map getAnswering(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "status", required = false) String status) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Production> productions = productionService.getProduction(name,status);
        if (productions == null || productions.size() == 0) {
            map.put("code", 400);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询成功");
            map.put("data", productions);
        }
        logger.info(":查询结果" + productions);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/production/{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Production production) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        production = productionService.selectByPrimaryKey(id);
        if (production == null) {
            map.put("code", 400);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询单条数据成功");
            map.put("data", production);
        }
        logger.info(":查询结果" + production);
        return map;
    }
}
