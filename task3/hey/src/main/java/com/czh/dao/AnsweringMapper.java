package com.czh.dao;

import com.czh.pojo.Answering;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnsweringMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Answering record);

    int insertSelective(Answering record);

    Answering selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Answering record);

    int updateByPrimaryKey(Answering record);

    List<Answering> getAnswering(@Param("nickname") String nickname, @Param("messageId") long messageId);
}