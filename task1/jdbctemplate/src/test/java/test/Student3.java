//package test;
//
//import java.sql.*;
//
//public class Student {
//    public static void main(String[] args) {
//        //初始化驱动
//        try {
//            //驱动类com.mysql.jdbc.Driver
//            //就在mysql-connector-java-5.0.8-bin.jar中
//            //如果忘记了第一个步骤的导包，就会报错
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            //建立与数据库的Connection连接
//            //这里需要提供；
//            //数据库所处于的ip:127.0.0.1(本机)
//            //数据库的端口号:3306(mysql专用端口号)
//            //数据库名称 business
//            //编码方法 UTF-8
//            //账号root
//            //密码admin
//            Connection c = DriverManager
//                    .getConnection("jdbc:mysql://127.0.0.1:3306/business?characterEncoding=UTF-8",
//                            "root", "890");
//            Statement s = c.createStatement();
//            //准备sql语句
//            //注意：字符串要用单引号'
//            String sql = "insert into student3 values(null,'王元博','QA','武汉大学','10010','知乎','10011','10012',)";
//            s.execute(sql);
//            String sql1 = "delete from student3 id=7";
//            s.execute(sql1);
//            String sql2 = "update student3 set name = '程政皓' where id = 8";
//            s.execute(sql2);
//            String sql3 = "select * from student3";
//            //执行查询语句，并把结果集返回给ResultSet
//            ResultSet rs = s.executeQuery(sql3);
//            while (rs.next()) {
//                int id = rs.getInt("id");//可以使用字段名
//                String name = rs.getString(2);//也可以使用字段的顺序
//                String type = rs.getString(3);
//                String gradSchool = rs.getString(4);
//                int onlineId = rs.getInt(5);
//                String channel = rs.getString(6);
//                long createAt = rs.getLong(7);
//                long updateAt = rs.getLong(8);
//                System.out.println(id+""+ name+""+type + " "+gradSchool+""+onlineId+""+channel+""+createAt+""+updateAt);
//            }
//            //不一定要在这里关闭ReultSet,因为Statement关闭的时候，会自动关闭ResuleSet
//            //rs.clos();
//        } catch (SQLException e) {
//            //TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
