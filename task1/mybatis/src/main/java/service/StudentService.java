package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    public int add(Student student);

    public boolean delete(int id);

    public boolean update(Student student);

    public Student get(int id);

    public List<Student> findA11();
}
