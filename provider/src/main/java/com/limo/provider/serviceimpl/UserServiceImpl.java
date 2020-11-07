package com.limo.provider.serviceimpl;

import com.limo.provider.entity.AdminUser;
import com.limo.provider.mapper.AdminUserMapper;
import com.limo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lib97
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
