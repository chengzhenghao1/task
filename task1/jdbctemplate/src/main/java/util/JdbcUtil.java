package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 工具类作用是初始化和连接数据库
 * 作用是初始化和连接数据库
 */
public class JdbcUtil {
    public static Connection getConection() {
        //加载mysql的驱动
        String Driver = "com.mysql.jdbc.Driver";
        //获得数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/business?useUnicode=true&characterEncoding=UTF-8&" +
                "serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "890";
        Connection c = null;
        //获取连接方法
        try {
            c = DriverManager.getConnection(url, user, password);
            Class.forName(Driver);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     * 定义一个静态方法，用于释放资源
     */
    public static void close(PreparedStatement ps, Connection c) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
