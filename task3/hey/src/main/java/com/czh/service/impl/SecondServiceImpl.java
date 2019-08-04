package com.czh.service.impl;

import com.czh.dao.SecondMapper;
import com.czh.pojo.Second;
import com.czh.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("SecondService")
public class SecondServiceImpl implements SecondService {
    @Autowired
    private SecondMapper secondMapper;

    Logger logger = Logger.getLogger(String.valueOf(SecondServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        int a = secondMapper.deleteByPrimaryKey(id);
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
    public int insert(Second record) {
        int a = secondMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Second record) {
        int a = secondMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Second selectByPrimaryKey(Long id) {
        return secondMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(Second record) {
        int a = secondMapper.updateByPrimaryKeySelective(record);
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
    public boolean updateByPrimaryKey(Second record) {
        int a = secondMapper.updateByPrimaryKey(record);
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
     * @param state
     * @return
     */
    @Override
    public List<Second> getSecond(String name, long state) {
        return secondMapper.getSecond(name, state);
    }
}
