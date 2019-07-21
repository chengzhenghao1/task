package test;

import com.czh.pojo.Student;
import com.czh.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    static Logger logger = Logger.getLogger(String.valueOf(StudentTest.class));

    @Autowired
    private StudentService studentService;

    Student s = new Student();

    @Test
    public void add() {
        s.setName("哈哈哈哈哈哈");
        s.setType("js");
        s.setGradSchool("你疯了");
        s.setOnlineId(233333);
        s.setChannel("全家");
        s.setCreateAt(1620);
        s.setUpdateAt(1621);
        studentService.add(s);
    }

    @Test
    public void delete() {
        studentService.delete(20);
    }

    @Test
    public void update() {
        s.setName("哈哈哈哈哈哈");
        s.setType("js");
        s.setGradSchool("你疯了");
        s.setOnlineId(233333);
        s.setChannel("全家");
        s.setCreateAt(1620);
        s.setUpdateAt(1621);
        s.setId(6);
        studentService.update(s);
    }

    @Test
    public void get() {
        Student student2 = studentService.get(59);
        logger.info(String.valueOf(student2));
    }

    @Test
    public void select() {
        List<Student> student2s = studentService.list();
        for (Student student2 : student2s) {
            logger.info(String.valueOf(student2));
        }
    }

    @Test
    public void total() {
        int total = studentService.total();
        logger.info(String.valueOf(total));
    }

    @Test
    public void find() {
        List<Student> student2s = studentService.findByName("白");
        for (Student student2 : student2s) {
            logger.info(String.valueOf(student2));
        }
    }
}
