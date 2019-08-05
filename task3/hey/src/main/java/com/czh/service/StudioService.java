package com.czh.service;

import com.czh.pojo.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudioService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Studio record);

    boolean updateByPrimaryKey(Studio record);

    List<Studio> getStudio(@Param("name") String name, @Param("status") Integer status);
}
