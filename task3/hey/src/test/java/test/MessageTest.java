package test;

import com.czh.pojo.Message;
import com.czh.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MessageTest {
    static Logger logger = Logger.getLogger(String.valueOf(MessageTest.class));

    @Autowired
    private MessageService messageService;

    Message s = new Message();

    @Test
    public void insert() {
        s.setTitle("蒙阿丽莎");
        s.setNickname("达芬奇");
        s.setStatus("被盗");
        s.setCreateAt(1998L);
        s.setUpdateAt(2019L);
        s.setEditor("文艺复兴时期作卓越的代表人物");
        messageService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        messageService.deleteByPrimaryKey(6L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setTitle("夜晚的咖啡馆");
        s.setNickname("文森特·威廉·梵高");
        s.setStatus("被盗");
        s.setCreateAt(1998L);
        s.setUpdateAt(2019L);
        s.setEditor("印象派的重要的画家");
        s.setId(2L);
        messageService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Message> messages = Collections.singletonList(messageService.selectByPrimaryKey(6L));
        for (Message message : messages) {
            logger.info(String.valueOf(message));
        }
    }

    @Test
    public void getMessage() {
        List<Message> list = messageService.getMessage(null,null);
        for(Message a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
