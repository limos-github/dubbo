package com.limo.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.limo.service.OrderService;
import com.limo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lib97
 */
@Service
@Component
class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    /** 通过 @Reference 注入*/
    @Reference
    UserService userService;

    @Override
    public String selectList() {
        try {
            logger.info("查询取得数据!");
            return userService.selectAll().toString();
        } catch (Exception e) {
            logger.error("异常{}", e);
            return "服务端查询失败，请检查参数！";
        }
    }
}
