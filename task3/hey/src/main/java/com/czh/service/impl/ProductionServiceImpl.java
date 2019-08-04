package com.czh.service.impl;

import com.czh.dao.ProductionMapper;
import com.czh.pojo.Production;
import com.czh.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("ProductionService")
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionMapper productionMapper;

    Logger logger = Logger.getLogger(String.valueOf(ProductionServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        int a = productionMapper.deleteByPrimaryKey(id);
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
    public int insert(Production record) {
        int a = productionMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Production record) {
        int a = productionMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Production selectByPrimaryKey(Long id) {
        return productionMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(Production record) {
        int a = productionMapper.updateByPrimaryKeySelective(record);
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
    public boolean updateByPrimaryKey(Production record) {
        int a = productionMapper.updateByPrimaryKey(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param name
     * @param status
     * @return
     */
    @Override
    public List<Production> getProduction(String name, String status) {
        return productionMapper.getProduction(name, status);
    }
}
