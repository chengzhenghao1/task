package com.czh.service.impl;

import com.czh.dao.MessageMapper;
import com.czh.pojo.Message;
import com.czh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    Logger logger = Logger.getLogger(String.valueOf(MessageServiceImpl.class));

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        int a = messageMapper.deleteByPrimaryKey(id);
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
    public int insert(Message record) {
        int a = messageMapper.insert(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Message record) {
        int a = messageMapper.insertSelective(record);
        logger.info("插入后的主键为" + record.getId());
        return a;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Message selectByPrimaryKey(Long id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    @Override
    public boolean updateByPrimaryKeySelective(Message record) {
        int a = messageMapper.updateByPrimaryKeySelective(record);
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
    public boolean updateByPrimaryKey(Message record) {
        int a = messageMapper.updateByPrimaryKey(record);
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param title
     * @param nickname
     * @return
     */
    @Override
    public List<Message> getMessage(String title, String nickname) {
        return messageMapper.getMessage(title, nickname);
    }
}
