package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    public int add(Student student);//int数据类型的方法返回值是return 0不止为0

    public boolean delete(int id);//boolean数据类型的方法返回值是true和false

    public boolean update(Student student);

    public Student get(int id);

    public List<Student> findA11();
}