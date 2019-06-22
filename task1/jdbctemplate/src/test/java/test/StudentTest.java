package test;


import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudentTest {

    @Test
    public void add() {
        Student student = new Student();
        student.setName("小白");
        student.setQq(11474);
        student.setType("PM");
        student.setTime0f(20191119);
        student.setGradSchool("河南科技大学");
        student.setOnlineId(19);
        student.setLink("修真院");
        student.setWish("网络");
        student.setChannel("嗯哼");
        student.setCreateAt(1487);
        student.setUpdateAt(145);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("StudentDao");
        dao.add(student);
    }

    @Test
    public void delete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("StudentDao");
        dao.delete(7);
    }

    @Test
    public void update() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("StudentDao");
        Student s = new Student();
        s.setGradSchool("郑大");
        s.setId(3);
        dao.update(s);
    }

    @Test
    public void get() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("StudentDao");
        dao.get(41);
    }

    @Test
    public void select() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("StudentDao");
        dao.findA11();
    }
}