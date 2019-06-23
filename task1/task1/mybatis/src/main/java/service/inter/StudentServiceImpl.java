package service.inter;

import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import service.StudentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(StudentServiceImpl.class));
    //读取mybatis配置文件，并读取成文字流形式（InputStream）

    String resource = "mybatis-config.xml";
    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将读取后的参数交给SqlSessionFactory进行节点读取
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();
    StudentDao service = session.getMapper(StudentDao.class);

    /**
     * @param student
     * @return
     */
    @Override
    public int add(Student student) {
        int a = service.add(student);
        logger.info("插入后主键为" + student.getId());//返回主键
        session.commit();//提交命令
        session.close();//关闭数据库
        return a;

    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        int a = service.delete(id);
        session.commit();
        session.close();
        if (a == 1) {
            logger.info("删除成功");
            return true;
        } else {
            logger.info("删除失败");
            return false;
        }
    }

    /**
     * @param student
     * @return
     */
    @Override
    public boolean update(Student student) {
        int a = service.update(student);
        session.commit();
        session.close();
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    @Override
    public Student get(int id) {
        Student a = service.get(id);
        session.commit();
        session.close();
        return a;
    }

    /**
     * @return
     */
    @Override
    public List<Student> findA11() {
        List<Student> students=service.findA11();
        session.commit();
        session.close();
        return students;
    }
}
