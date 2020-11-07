package com.limo.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.limo.service.OrderService;
import com.limo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lib97
 *
 * 使用dubbo的@Service暴露服务，如果不使用就不显示为提供者
 */
@Service
class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    /** 通过 @Reference 注入属性；@Reference(loadbalance = "roundrobin")
     *
     * 负载均衡策略，可选值：random,roundrobin,leastactive，分别表示：随机，轮询，最少活跃调用
     * 缺省使用<dubbo:consumer>的timeout 服务方法调用超时时间(毫秒)
     * 缺省使用<dubbo:consumer>的connections 对每个提供者的最大连接数，rmi、http、hessian等短连接协议表示限制连接数，dubbo等长连接协表示建立的长连接个数等
     * 缺省使用<dubbo:consumer>的retries远程服务调用重试次数，不包括第一次调用，不需要重试请设为0
     * */
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
