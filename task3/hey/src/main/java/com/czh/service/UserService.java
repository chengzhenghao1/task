package com.czh.service;

import com.czh.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    boolean deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(User record);

    boolean updateByPrimaryKey(User record);

    List<User> getUser(@Param("username") String name, @Param("role") String role);
}
