package test;

import com.czh.pojo.User;
import com.czh.service.UserService;
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
public class UserTest {
    static Logger logger = Logger.getLogger(String.valueOf(UserTest.class));

    @Autowired
    private UserService userService;

    User s = new User();

    @Test
    public void insert() {
        s.setUsername("用户姓名");
        s.setPassword("用户密码");
        s.setRole("角色");
        s.setCreateAt(2100L);
        s.setUpdateAt(2101L);
        s.setEditor("编辑人");
        userService.insert(s);
    }

    @Test
    public void deleteByPrimaryKey() {
        userService.deleteByPrimaryKey(2);
    }

    @Test
    public void updateByPrimaryKey() {
        s.setUsername("啦啦啦啦啦");
        s.setPassword("用户密码");
        s.setRole("角色");
        s.setCreateAt(2100L);
        s.setUpdateAt(2101L);
        s.setEditor("编辑人");
        s.setId(5);
        userService.updateByPrimaryKey(s);
    }

    @Test
    public void selectByPrimaryKey() {
        List<User> users = Collections.singletonList(userService.selectByPrimaryKey(2));
        for (User user : users) {
            logger.info(String.valueOf(user));
        }
    }

    @Test
    public void getArticle() {
        List<User> list = userService.getUser("卡", "角色");
        for (User a : list) {
            logger.info(String.valueOf(a));
        }
    }
}
