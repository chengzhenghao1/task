package Test;

import org.springframework.beans.factory.annotation.Autowired;
import service.StudentService;
import entity.Student;
import service.inter.StudentServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;


public class TestService {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(TestService.class));

    @Autowired
    StudentService service = new StudentServiceImpl();

    Student s = new Student();

    @Test
    public void add() {
        s.setName("燕麦");
        s.setQq(15996457);
        s.setType("UI");
        s.setTime0f(787);
        s.setGradSchool("武汉大学");
        s.setOnlineId(11);
        s.setLink("修真院");
        s.setWish("长胖十斤");
        s.setChannel("知识星球");
        s.setCreateAt(2019);
        s.setUpdateAt(2018);
        service.add(s);
    }

    @Test
    public void delete() {
        s.setQq(456789);
        service.delete(456789);
    }

    @Test
    public void update() {
        s.setId(10);
        s.setChannel("嘎嘎嘎");
        service.update(s);
    }

       @Test
    public void get() {
        List<Student> list = service.get(11474);
        logger.info(String.valueOf(list));
    }

    @Test
    public void select() {
        List<Student> students = service.findA11();
        for (Student student:students) {
            logger.info(String.valueOf(student));
        }
    }
}
