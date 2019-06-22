package test;

import Utils.MybatisUtils;
import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class TestStudent {
    Student s = new Student();//new一个新对象
    SqlSession sqlSession = MybatisUtils.getSqlSession();//使用工具类

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
        sqlSession.insert("add", s);
        sqlSession.commit();
        sqlSession.close();//关闭连接，释放资源
    }

    @Test
    public void delete() {
        s.setId(9);
        sqlSession.delete("delete", s);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        s.setId(8);
        s.setName("李华");
        sqlSession.update("update", s);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getByName() {
        s.setName("王一");
        s = sqlSession.selectOne("get", s);
    }

    @Test
    public void select() {
        listAll(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    private static void listAll(SqlSession session) {
        List<Student> ss = session.selectList("list");
        for (Student s : ss) {
            System.out.print(s.getName());
        }
    }
}
