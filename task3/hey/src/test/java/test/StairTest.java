package test;

import com.czh.pojo.Stair;
import com.czh.service.StairService;
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
public class StairTest {
    static Logger logger = Logger.getLogger(String.valueOf(StairTest.class));

    @Autowired
    private StairService stairService;

    Stair s = new Stair();

    @Test
    public void insert() {
        s.setName("一级作品集名称");
        s.setState(0);
        s.setCreateAt(2037L);
        s.setUpdateAt(2038L);
        s.setEditor("编辑人");
        stairService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        stairService.deleteByPrimaryKey(2L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setName("一级");
        s.setState(0);
        s.setCreateAt(2037L);
        s.setUpdateAt(2038L);
        s.setEditor("编辑人");
        s.setId(11L);
        stairService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Stair> stairs = Collections.singletonList(stairService.selectByPrimaryKey(2L));
        for (Stair stair : stairs) {
            logger.info(String.valueOf(stair));
        }
    }

    @Test
    public void getStair() {
        List<Stair> list = stairService.getStair("名字", 0);
        for (Stair a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
