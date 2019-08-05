package test;

import com.czh.pojo.Studio;
import com.czh.service.StudioService;
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
public class StudioTest {
    static Logger logger = Logger.getLogger(String.valueOf(StudioTest.class));

    @Autowired
    private StudioService studioService;

    Studio s = new Studio();

    @Test
    public void insert() {
        s.setName("简介类型");
        s.setStatus(0);
        s.setPicture("工作室图片");
        s.setMainBody("正文");
        s.setCreateAt(2049L);
        s.setUpdateAt(2050L);
        s.setEditor("编辑人");
        studioService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        studioService.deleteByPrimaryKey(2L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setName("类型");
        s.setStatus(0);
        s.setPicture("工作室图片");
        s.setMainBody("政党");
        s.setCreateAt(2049L);
        s.setUpdateAt(2050L);
        s.setEditor("编辑人");
        s.setId(10L);
        studioService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Studio> studios = Collections.singletonList(studioService.selectByPrimaryKey(2L));
        for (Studio studio : studios) {
            logger.info(String.valueOf(studio));
        }
    }

    @Test
    public void getStudio() {
        List<Studio> list = studioService.getStudio("张大千", 1);
        for (Studio a : list) {
            logger.info(String.valueOf(a));
        }
    }
}