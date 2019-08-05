package test;

import com.czh.pojo.Answering;
import com.czh.service.AnsweringService;
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
public class AnsweringTest {
    static Logger logger = Logger.getLogger(String.valueOf(AnsweringTest.class));

    @Autowired
    private AnsweringService answeringService;

    Answering s = new Answering();

    @Test
    public void insert() {
//        s.setId(2L);
        s.setNickname("吴冠中");
        s.setMessageId(23L);
        s.setResponse("这画的真菜");
        s.setCreateAt((long) 20190728);
        s.setUpdateAt((long) 20190728);
        s.setEditor("哪吒");
        answeringService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        answeringService.deleteByPrimaryKey(7);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setNickname("郭碧婷");
        s.setMessageId(20L);
        s.setResponse("凑合吧");
        s.setCreateAt(11121L);
        s.setUpdateAt(111111L);
        s.setEditor("零小灵通");
        s.setId(30L);
        answeringService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Answering> answerings = Collections.singletonList(answeringService.selectByPrimaryKey((long) 1));
        for (Answering answering : answerings) {
            logger.info(String.valueOf(answering));
        }
    }

    @Test
    public void getAnswering() {
        List<Answering> list = answeringService.getAnswering("吴",19);
        for(Answering a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
