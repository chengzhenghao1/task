package com.czh.service.inter;

import com.czh.dao.StudentMapper;
import com.czh.pojo.Student;
import com.czh.service.StudentService;
import com.czh.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    Logger logger = Logger.getLogger(String.valueOf(StudentServiceImpl.class));

    @Override
    public int add(Student student) {
        int a = studentMapper.add(student);
        logger.info("插入后的主键为" + student.getId());
        return a;
    }

    @Override
    public boolean delete(int id) {
        int a = studentMapper.delete(id);
        if (a == 1) {
            logger.info("删除成功");
            return true;
        } else {
            logger.info("删除失败");
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        int a = studentMapper.update(student);
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
        return studentMapper.get(id);
    }

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public List<Student> list(Page page) {
        return studentMapper.list(page);
    }

    @Override
    public int count() {
        return studentMapper.count();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentMapper.findByName(name);
    }

    @Override
    public int total() {
        return studentMapper.total();
    }


}
