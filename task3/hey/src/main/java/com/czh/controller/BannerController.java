package com.czh.controller;

import com.czh.pojo.Banner;
import com.czh.service.BannerService;
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
public class BannerController {
    Logger logger = Logger.getLogger(String.valueOf(BannerController.class));

    @Autowired
    BannerService bannerService;

    @ResponseBody
    @RequestMapping(value = "/a/u/banner", method = RequestMethod.POST)
    public Map insert(Banner banner) {
        logger.info("进入添加方法");
        Map<String, Object> map = new HashMap();
        int a = bannerService.insert(banner);
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
    @RequestMapping(value = "/a/u/banner/{id}", method = RequestMethod.DELETE)
    public Map deleteBanner(@PathVariable Long id) {
        logger.info("进入删除方法");
        Map<String, Object> map = new HashMap();
        boolean a = bannerService.deleteByPrimaryKey(id);
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
    @RequestMapping(value = "/a/u/banner/{id}", method = RequestMethod.PUT)
    public Map updateBanner(@PathVariable Long id, Banner banner) {
        logger.info("进入编辑");
        Map<String, Object> map = new HashMap();
        boolean a = bannerService.updateByPrimaryKey(banner);
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
    @RequestMapping(value = "/a/u/banner", method = RequestMethod.GET)
    public Map getBanner(@RequestParam(value = "cover", required = false) String cover,
                         @RequestParam(value = "state", required = false) long state) {
        logger.info("进入条件查询");
        Map<String, Object> map = new HashMap();
        List<Banner> banners = bannerService.getBanner(cover, state);
        if (banners == null || banners.size() == 0) {
            map.put("code", 400);
            map.put("message", "查询失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询成功");
            map.put("data", banners);
        }
        logger.info(":查询结果" + banners);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/a/banner/{id}", method = RequestMethod.GET)
    public Map getId(@PathVariable Long id, Banner banner) {
        logger.info("进入单条查询");
        Map<String, Object> map = new HashMap();
        banner = bannerService.selectByPrimaryKey(id);
        if (banner == null) {
            map.put("code", 400);
            map.put("message", "查询单条数据失败");
            map.put("data", "无法查找结果");
        } else {
            map.put("code", 200);
            map.put("message", "查询单条数据成功");
            map.put("data", banner);
        }
        logger.info(":查询结果" + banner);
        return map;
    }
}