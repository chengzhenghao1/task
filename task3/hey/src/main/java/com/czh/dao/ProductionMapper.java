package com.czh.dao;

import com.czh.pojo.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);

    List<Production> getProduction(@Param("name") String name, @Param("status") String status);
}