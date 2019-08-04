package com.czh.service.impl;

import com.czh.dao.BannerMapper;
import com.czh.pojo.Banner;
import com.czh.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("BannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    Logger logger = Logger.getLogger(String.valueOf(BannerServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        int a = bannerMapper.deleteByPrimaryKey(id);
        if (a == 1) {
            logger.info("删除成功");
            return true;
        } else {
            logger.info("删除失败");
            return false;
        }
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insert(Banner record) {
        int a = bannerMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Banner record) {
        int a = bannerMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(Banner record) {
        int a = bannerMapper.updateByPrimaryKeySelective(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKey(Banner record) {
        int a = bannerMapper.updateByPrimaryKey(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param cover
     * @param state
     * @return
     */
    @Override
    public List<Banner> getBanner(String cover, long state) {
        return bannerMapper.getBanner(cover, state);
    }
}
