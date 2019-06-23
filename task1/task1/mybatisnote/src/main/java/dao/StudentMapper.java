package dao;

import entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Insert("insert into student (id,name,qq,type,time0f,gradschool,online_id,link,wish,channel,create_at,update_at)values (#{id},#{name},\n" +
            "        #{qq},#{type},#{time0f},#{gradSchool},#{onlineId},#{link},#{wish},#{channel},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")//增加这个注解插入
    public int add(Student student);

    @Delete("delete from student where id=#{id}")
    public int delete(int id);

    @Update("update student set channel=#{channel} where id=#{id}")
    public int update(Student student);

    @Select("select * from student where qq=#{qq}")
    public List<Student> get(int qq);

    @Select("select * from student")
    public List<Student> findA11();
}
