package test;

import com.czh.pojo.Banner;
import com.czh.service.BannerService;
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
public class BannerTest {
    static Logger logger = Logger.getLogger(String.valueOf(BannerTest.class));

    @Autowired
    private BannerService bannerService;

    Banner s = new Banner();

    @Test
    public void insert() {
        s.setCover("假装这是一张图");
        s.setEditor("文章");
        s.setUrl("https://desktop.telegram.org/");
        s.setState(1);
        s.setCreateAt(201907281915L);
        s.setUpdateAt(2019777888L);
        bannerService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        bannerService.deleteByPrimaryKey(2L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setCover("文章离婚");
        s.setEditor("马伊利");
        s.setUrl("http://society.huanqiu.com/article/2019-07/15211520.html");
        s.setState(0);
        s.setCreateAt(11111L);
        s.setUpdateAt(22222222L);
        s.setId(2L);
        bannerService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Banner> banners = Collections.singletonList(bannerService.selectByPrimaryKey(2L));
        for (Banner banner : banners) {
            logger.info(String.valueOf(banner));
        }
    }

    @Test
    public void getBanner() {
        List<Banner> list = bannerService.getBanner(null, 0);
        for (Banner a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
