package com.czh.service.impl;

import com.czh.dao.UserMapper;
import com.czh.pojo.User;
import com.czh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        int a = userMapper.deleteByPrimaryKey(id);
        if (a == 1) {
            logger.info("删除成功");
            return true;
        } else {
            logger.info("删除失败");
            return false;
        }
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(User record) {
        int a = userMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(User record) {
        int a = userMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(User record) {
        int a = userMapper.updateByPrimaryKeySelective(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }


    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKey(User record) {
        int a = userMapper.updateByPrimaryKey(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }


    /**
     * @param usaername
     * @param role
     * @return
     */
    @Override
    public List<User> getUser(String usaername, String role) {
        return userMapper.getUser(usaername, role);
    }
}
