package com.czh.service;

import com.czh.pojo.Second;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Second record);

    int insertSelective(Second record);

    Second selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Second record);

    boolean updateByPrimaryKey(Second record);

    List<Second> getSecond(@Param("name") String name, @Param("state") long state);
}
