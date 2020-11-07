package com.limo.provider.controller;

import com.limo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PrivoiderController {
    private static final Logger logger = LoggerFactory.getLogger(PrivoiderController.class);
    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping("/hello/{id}")
    public String helloAdmin(@PathVariable int id){
        try {
            logger.debug("查询取得数据!");
            return userService.selectByPrimaryKey(id).toString();
        }catch (Exception e){
            logger.error("异常{}",e);
            return "查询失败，请检查参数！";
        }
    }
}
