package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    public int add(Student student);

    public int delete(int id);

    public int update(Student student);

    public Student get(int id);

    public List<Student> findA11();
}
