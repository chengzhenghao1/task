package com.czh.service;

import com.czh.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Message record);

    boolean updateByPrimaryKey(Message record);

    List<Message> getMessage(@Param("title") String title, @Param("nickname") String nickname);
}
