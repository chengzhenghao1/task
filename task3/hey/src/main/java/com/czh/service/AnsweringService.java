package com.czh.service;

import com.czh.pojo.Answering;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnsweringService {
    boolean deleteByPrimaryKey(long id);

    int insert(Answering record);

    int insertSelective(Answering record);

    Answering selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Answering record);

    boolean updateByPrimaryKey(Answering record);

    List<Answering> getAnswering(@Param("nickname") String nickname, @Param("messageId") long messageId);
}
