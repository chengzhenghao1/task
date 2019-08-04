package com.czh.service;

import com.czh.pojo.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Production record);

    boolean updateByPrimaryKey(Production record);

    List<Production> getProduction(@Param("name") String name, @Param("status") String status);
}
