package com.czh.controller;

import com.czh.pojo.Message;
import com.czh.service.MessageService;
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
public class MessageController {
    Logger logger = Logger.getLogger(String.valueOf(MessageController.class));

    @Autowired
    MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/a/u/message", method = RequestMethod.POST)
    public Map insert(Message message) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = messageService.insert(message);
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
    @RequestMapping(value = "/a/u/message/{id}", method = RequestMethod.DELETE)
    public Map deleteMessage(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = messageService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/message/{id}", method = RequestMethod.PUT)
    public Map updateMessage(@PathVariable Long id, Message message) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = messageService.updateByPrimaryKey(message);
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
    @RequestMapping(value = "/a/u/message", method = RequestMethod.GET)
    public Map getUser(@RequestParam(value = "title", required = false) String title,
                       @RequestParam(value = "nickname", required = false) String nickname) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Message> messages = messageService.getMessage(title, nickname);
        if (messages == null || messages.size() == 0) {
            map.put("code", 400);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询成功");
            map.put("data", messages);
        }
        logger.info(":查询结果" + messages);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/message/{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Message message) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        message = messageService.selectByPrimaryKey(id);
        if (message == null) {
            map.put("code", 400);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询单条数据成功");
            map.put("data", message);
        }
        logger.info(":查询结果" + message);
        return map;
    }
}
