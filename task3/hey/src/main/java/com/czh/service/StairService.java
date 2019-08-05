package com.czh.service;

import com.czh.pojo.Stair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StairService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Stair record);

    int insertSelective(Stair record);

    Stair selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Stair record);

    boolean updateByPrimaryKey(Stair record);

    List<Stair> getStair(@Param("name") String name, @Param("state") Integer state);
}
