package impl;

import dao.StudentDao;
import entity.Student;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentDaoImpl implements StudentDao {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(StudentDaoImpl.class));//声明工具类

    /**
     * @param student
     * @return
     */
    @Override
    public int add(Student student) {
        int a = 0;//定义变量同时赋初值
        Connection c = JdbcUtil.getConection();//定义工具类JdbcUtil的变量
        String sql = "insert into student values (null,?,?,?,?,?,?,?,?,?,?,?)";//sql语句

        try {
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//预编译
            ps.setString(1, student.getName());
            ps.setInt(2, student.getQq());
            ps.setString(3, student.getType());
            ps.setLong(4, student.getTime0f());
            ps.setString(5, student.getGradSchool());
            ps.setInt(6, student.getOnlineId());
            ps.setString(7, student.getLink());
            ps.setString(8, student.getWish());
            ps.setString(9, student.getChannel());
            ps.setLong(10, student.getCreateAt());
            ps.setLong(11, student.getUpdateAt());
            ps.executeUpdate();//执行插入语句
            //在执行完插入语句后，MySQL会为新插入的数据分配一个自增长
            //JDBC通过gerGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                logger.info("新增主键：" + id);
            }
            //调用工具类释放资源
            rs.close();
            JdbcUtil.close(ps, c);//关闭三个资源
        } catch (SQLException e) {//可能发生异常的类型以及异常发生后需要做的处理
            e.printStackTrace();
        }
        return 0;//代表程序正常退出
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        Connection c = JdbcUtil.getConection();
        String sql = "delete from student where id=?";
        int a = 0;

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        Connection c = JdbcUtil.getConection();
        int a = 0;
        try {
            String sql = "update student set gradSchool=? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, student.getGradSchool());
            ps.setInt(2, student.getId());
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a == 1) {
            logger.info("更改成功");
            return true;
        } else {
            logger.info("更改失败");
            return false;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student get(int id) {
        Connection c = JdbcUtil.getConection();
        String sql = "select * from student where id=?";

        try {
            PreparedStatement ps = c.prepareStatement(sql);//执行查询语句，并把结果集返回给ResultSet
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();//可以执行查询语句，然后通过getResultSet，把结果集取出来
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setQq(rs.getInt(3));
                s.setType(rs.getString(4));
                s.setTime0f(rs.getLong(5));
                s.setGradSchool(rs.getString(6));
                s.setOnlineId(rs.getInt(7));
                s.setLink(rs.getString(8));
                s.setWish(rs.getString(9));
                s.setChannel(rs.getString(10));
                s.setCreateAt(rs.getLong(11));
                s.setUpdateAt(rs.getLong(12));
                logger.info(String.valueOf(s));
            }
            //调用工具类释放资源
            rs.close();
            JdbcUtil.close(ps, c);//关闭三个资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;//跳出方法并返回
    }

    @Override
    public List<Student> findA11() {

        List<Student> students = new ArrayList<Student>();
        Connection c = JdbcUtil.getConection();
        String sql = "select * from student";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setQq(rs.getInt("qq"));
                s.setType(rs.getString("type"));
                s.setTime0f(rs.getLong("time0f"));
                s.setGradSchool(rs.getString("gradSchool"));
                s.setOnlineId(rs.getInt("online_id"));
                s.setLink(rs.getString("link"));
                s.setWish(rs.getString("wish"));
                s.setChannel(rs.getString("channel"));
                s.setCreateAt(rs.getLong("create_at"));
                s.setUpdateAt(rs.getLong("update_at"));
                logger.info(String.valueOf(s));
                students.add(s);
            }
            //调用工具类释放资源
            rs.close();
            JdbcUtil.close(ps, c);//关闭三个资源
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

