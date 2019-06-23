package test;

import org.apache.log4j.Logger;
import service.StudentService;
import entity.Student;
import service.inter.StudentServiceImpl;

import org.junit.Test;

import java.util.List;


public class TestService {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(TestService.class));

    StudentService service = new StudentServiceImpl();
    Student s = new Student();

    @Test
    public void add() {
        s.setName("抹茶曲奇");
        s.setQq(123456789);
        s.setType("UI");
        s.setTime0f(12);
        s.setGradSchool("中国传媒大学");
        s.setOnlineId(31);
        s.setLink("修真院");
        s.setWish("网络");
        s.setChannel("盆友");
        s.setCreateAt(2019);
        s.setUpdateAt(2018);
        service.add(s);
    }

    @Test
    public void delete() {
        s.setId(9);
        service.delete(9);
    }

    @Test
    public void update() {
        s.setId(8);
        s.setName("李华");
        service.update(s);
    }
    @Test
    public void get(){
        Student student=service.get(2);
        logger.info(student);
    }
    @Test
    public void select(){
        List<Student> students=service.findA11();
        for (Student student:students){
            logger.info(student);
        }
    }
}

