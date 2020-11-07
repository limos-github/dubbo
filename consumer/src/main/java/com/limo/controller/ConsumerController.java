package com.limo.controller;

import com.limo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author lib97
 */
@Controller
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/hello")
    public String helloAdmin() {
        try {
            logger.debug("接收到查询数据请求!");
            return orderService.selectList();
        } catch (Exception e) {
            logger.error("异常{}", e);
            return "查询失败，请检查参数！";
        }
    }
}
