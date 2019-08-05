package test;

import com.czh.pojo.Second;
import com.czh.service.SecondService;
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
public class SecondTest {
    static Logger logger = Logger.getLogger(String.valueOf(SecondTest.class));

    @Autowired
    private SecondService secondService;

    Second s = new Second();

    @Test
    public void insert() {
        s.setName("作品名称");
        s.setStairId(9L);
        s.setState(0);
        s.setCreateAt(2021L);
        s.setUpdateAt(2022L);
        s.setEditor("编辑人");
        secondService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        secondService.deleteByPrimaryKey(6L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setName("星夜");
        s.setStairId(7L);
        s.setState(0);
        s.setCreateAt(2021L);
        s.setUpdateAt(2022L);
        s.setEditor("编辑人");
        s.setId(16L);
        secondService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Second> seconds = Collections.singletonList(secondService.selectByPrimaryKey(2L));
        for (Second second : seconds) {
            logger.info(String.valueOf(second));
        }
    }

    @Test
    public void getScond() {
        List<Second> list = secondService.getSecond("明儿", 1);
        for (Second a : list) {
            logger.info(String.valueOf(a));
        }
    }
}

