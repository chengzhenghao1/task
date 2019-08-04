package test;

import com.czh.pojo.Production;
import com.czh.service.ProductionService;
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
public class ProductionTest {
    static Logger logger = Logger.getLogger(String.valueOf(ProductionTest.class));

    @Autowired
    private ProductionService productionService;

    Production s = new Production();

    @Test
    public void insert() {
        s.setName("名称");
        s.setStatus("状态");
        s.setStairId(8L);
        s.setSecondId(17L);
        s.setProduction("作品简介");
        s.setThumbnail("缩略图");
        s.setVideoLink("视频链接");
        s.setPhoto("作品详情图片");
        s.setIntroduction("介绍文章");
        s.setCreateAt(2005L);
        s.setUpdateAt(2006L);
        s.setEditor("编辑人");
        productionService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        productionService.deleteByPrimaryKey(6L);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setName("名称");
        s.setStatus("状态");
        s.setStairId(1L);
        s.setSecondId(2L);
        s.setProduction("作品简介");
        s.setThumbnail("缩略图");
        s.setVideoLink("视频链接");
        s.setPhoto("作品详情图片");
        s.setIntroduction("介绍文章");
        s.setCreateAt(2005L);
        s.setUpdateAt(2006L);
        s.setEditor("编辑人");
        s.setId(2L);
        productionService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<Production> productions = Collections.singletonList(productionService.selectByPrimaryKey(2L));
        for (Production production : productions) {
            logger.info(String.valueOf(production));
        }
    }

    @Test
    public void getPrimaryKey() {
        List<Production> list = productionService.getProduction(null, "状态");
        for (Production a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
