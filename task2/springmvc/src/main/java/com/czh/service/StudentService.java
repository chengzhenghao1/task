package com.czh.service;

import com.czh.pojo.Student;
import com.czh.util.Page;

import java.util.List;

public interface StudentService {
    int add(Student student);

    boolean delete(int id);

    boolean update(Student student);

    Student get(int id);

    List<Student> list();

    List<Student> list(Page page);

    int total();

    int count();

    List<Student> findByName(String name);
}
