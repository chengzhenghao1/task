package com.czh.dao;

import com.czh.pojo.Student;
import com.czh.util.Page;

import java.util.List;

public interface StudentMapper {
    int add(Student student);

    int delete(int id);

    Student get(int id);

    int update(Student student);

    List<Student> list();

    List<Student> list(Page page);

    int count();

    int total();

    List<Student> findByName(String name);
}
