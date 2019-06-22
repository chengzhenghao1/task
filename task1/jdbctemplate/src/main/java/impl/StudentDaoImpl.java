package impl;

import dao.StudentDao;
import entity.Student;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(StudentDaoImpl.class));

    /**
     * @param student
     * @return
     */
    @Override
    public int add(final Student student) {
        final String sql = "insert into student values (null,?,?,?,?,?,?,?,?,?,?,?)";
        final KeyHolder holder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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
                return ps;
            }
        }, holder);
        int id = holder.getKey().intValue();
        logger.info("新增主键；" + id);
        return id;
    }

    /**
     * @param id
     * @return
     */

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id=?";
        int a = this.getJdbcTemplate().update(sql, id);
        //定义变量同时赋初值
        if (a == 1) {//判断a是否等于1，条件成立执行true
            logger.info("删除成功");
            return true;
        } else {
            logger.info("删除失败");
            return false;//条件不成立执行false
        }
    }

    /**
     * @param student
     * @return
     */
    @Override
    public boolean update(Student student) {
        String sql = "update student set gradSchool=? where id=?";
        int a = this.getJdbcTemplate().update(sql, student.getGradSchool(), student.getId());
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
        Student s = new Student();
        String sql = "select * from student where id=?";
//        id = Integer.parseInt(this.getJdbcTemplate().queryForObject(sql, String.class, id));
        this.getJdbcTemplate().queryForList(sql, String.class, s.getId());
        logger.info(String.valueOf(s));
        return null;
    }


    @Override
    public List<Student> findA11() {
        String sql = "select * from student";
        return this.getJdbcTemplate().query(sql, new StudentRowMapper());
    }

    class StudentRowMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setQq(rs.getInt("qq"));
            student.setType(rs.getString("type"));
            student.setTime0f(rs.getInt("time0f"));
            student.setGradSchool(rs.getString("gradSchool"));
            student.setOnlineId(rs.getInt("online_id"));
            student.setLink(rs.getString("link"));
            student.setWish(rs.getString("wish"));
            student.setChannel(rs.getString("channel"));
            student.setCreateAt((long) rs.getLong("create_at"));
            student.setUpdateAt((long) rs.getLong("update_at"));
            logger.info(String.valueOf(student));
            return student;
        }
    }
}
