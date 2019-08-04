package com.czh.service;

import com.czh.pojo.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Banner record);

    boolean updateByPrimaryKey(Banner record);

    List<Banner> getBanner(@Param("cover") String cover, @Param("state") long state);
}
