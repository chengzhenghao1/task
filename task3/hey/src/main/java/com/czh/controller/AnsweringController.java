package com.czh.controller;

import com.czh.pojo.Answering;
import com.czh.service.AnsweringService;
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
public class AnsweringController {
    Logger logger = Logger.getLogger(String.valueOf(AnsweringController.class));

    @Autowired
    AnsweringService answeringService;

    @ResponseBody
    //JSON注解直接输出到页面
    @RequestMapping(value = "/a/u/answering", method = RequestMethod.POST)
    //传值方法,请求方法限定
    public Map insert(Answering answering) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        /*Map对象的键是String类型的，而值因为被定义为最上层的java对象Object对象
        而所有下级对象都隶属于Object对象，所有可以传任何类型的值在里面*/
        int a = answeringService.insert(answering);
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
    @RequestMapping(value = "/a/u/answering/{id}", method = RequestMethod.DELETE)
    public Map deleteAnswering(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = answeringService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/answering/{id}", method = RequestMethod.PUT)
    public Map updateAnswering(@PathVariable Long id, Answering answering) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = answeringService.updateByPrimaryKey(answering);
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
    @RequestMapping(value = "/a/u/answering", method = RequestMethod.GET)
    public Map getAnswering(@RequestParam(value = "nickname", required = false) String nickname,
                            @RequestParam(value = "messageId", required = false) long messageId) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Answering> answerings = answeringService.getAnswering(nickname, messageId);
        if (answerings == null || answerings.size() == 0) {
            map.put("code", 200);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询成功");
            map.put("data", answerings);
        }
        logger.info(":查询结果" + answerings);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/answering/{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Answering answering) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        answering = answeringService.selectByPrimaryKey(id);
        if (answering == null) {
            map.put("code", 200);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 400);
            map.put("message", "查询单条数据成功");
            map.put("data", answering);
        }
        logger.info(":查询结果" + answering);
        return map;
    }
}
