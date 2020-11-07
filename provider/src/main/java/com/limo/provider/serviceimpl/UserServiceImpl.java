package com.limo.provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.limo.provider.entity.AdminUser;
import com.limo.provider.mapper.AdminUserMapper;
import com.limo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lib97
 *
 * 使用dubbo的@Service暴露服务，如果不使用就不显示为提供者
 */
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public AdminUserMapper adminUserMapper;

    @Override
    public List<AdminUser> selectAll() {
        try {
            logger.info("查询数据库!");
            return adminUserMapper.selectAll();
        } catch (Exception e) {
            logger.error("异常{}", e);
            return null;
        }
    }

    @Override
    public String selectByPrimaryKey(int id) {
        try {
            logger.debug("查询取得数据!");
            return adminUserMapper.selectByPrimaryKey(id).toString();
        }catch (Exception e){
            logger.error("异常{}",e);
            return "查询失败，请检查参数！";
        }
    }


}
