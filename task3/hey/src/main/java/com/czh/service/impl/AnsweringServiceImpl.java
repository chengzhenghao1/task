package com.czh.service.impl;

import com.czh.dao.AnsweringMapper;
import com.czh.pojo.Answering;
import com.czh.service.AnsweringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("answeringService")
public class AnsweringServiceImpl implements AnsweringService {
    @Autowired
    private AnsweringMapper answeringMapper;

    Logger logger = Logger.getLogger(String.valueOf(AnsweringServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(long id) {
        int a = answeringMapper.deleteByPrimaryKey(id);
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
    public int insert(Answering record) {
        int a = answeringMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Answering record) {
        int a = answeringMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getMessageId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Answering selectByPrimaryKey(Long id) {
        return answeringMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(Answering record) {
        int a = answeringMapper.updateByPrimaryKeySelective(record);
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
    public boolean updateByPrimaryKey(Answering record) {
        int a = answeringMapper.updateByPrimaryKey(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param nickname
     * @param commentId
     * @return
     */
    @Override
    public List<Answering> getAnswering(String nickname, long commentId) {
        return answeringMapper.getAnswering(nickname, commentId);
    }
}