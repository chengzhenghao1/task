package com.czh.dao;

import com.czh.pojo.Stair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StairMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stair record);

    int insertSelective(Stair record);

    Stair selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stair record);

    int updateByPrimaryKey(Stair record);

    List<Stair> getStair(@Param("name") String name, @Param("state") long state);
}