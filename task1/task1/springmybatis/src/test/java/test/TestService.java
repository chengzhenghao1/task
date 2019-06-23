package test;

import com.zz.service.StudentService;
import com.zz.entity.Student;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)//让测试运行于Spring运行环境中
@ContextConfiguration("classpath:applicationContext.xml")//用来指定加载的Spring配置文件的位置，再默认的配置文件
public class TestService {

    static Logger logger = Logger.getLogger(TestService.class);//声明Logger的私有属性
    @Autowired
    private StudentService studentService;//注解注入接口

    Student s = new Student();

    @Test
    public void add() {
        s.setName("绿茶");
        s.setQq(449642);
        s.setType("PM");
        s.setTime0f(77);
        s.setGradSchool("宁波大学");
        s.setOnlineId(11);
        s.setLink("修真院");
        s.setWish("梦想要有的");
        s.setChannel("朋友介绍");
        s.setCreateAt(111);
        s.setUpdateAt(222);
        studentService.add(s);
    }

    @Test
    public void delete() {
        s.setQq(96);
        studentService.delete(18);
    }

    @Test
    public void update() {
        s.setType("QA");
        s.setId(8);
        studentService.update(s);
    }

    @Test
    public void get() {
        Student student = studentService.get(113);
        logger.info(student);
    }

    @Test
    public void select() {
        List<Student> students = studentService.findA11();
        for (Student student : students) {
            logger.info(student);
        }
    }
}