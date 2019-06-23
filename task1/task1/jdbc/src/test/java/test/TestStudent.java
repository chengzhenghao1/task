package test;

import entity.Student;
import impl.StudentDaoImpl;
import org.junit.Test;


public class TestStudent {

    @Test
    public void add() {
        StudentDaoImpl dao = new StudentDaoImpl();
        Student s = new Student();
        s.setName("王芳");
        s.setQq(123456);
        s.setType("java");
        s.setTime0f(20190607);
        s.setGradSchool("河南科技大学");
        s.setOnlineId(1122);
        s.setLink("修真院");
        s.setWish("加油");
        s.setChannel("贴吧");
        s.setCreateAt(20190607);
        s.setUpdateAt(20190606);
        dao.add(s);
    }

    @Test
    public void delete() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.delete(17);
    }

    @Test
    public void update() {
        StudentDaoImpl dao = new StudentDaoImpl();
        Student s = new Student();
        s.setId(9);
        s.setGradSchool("郑大");
        dao.update(s);
    }

    @Test
    public void get() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.get(1);
    }

    @Test
    public void select() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.findA11();
    }
}
