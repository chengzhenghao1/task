package com.zz.service.inter;

import com.zz.dao.StudentMapper;
import com.zz.entity.Student;
import com.zz.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")//自动注册到Spring容器，不需要再在applicationContext里面定义bean
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;//IOC方式获取一个对象

    Logger logger = Logger.getLogger(StudentServiceImpl.class);//声明logger的私有属性

    @Override
    public int add(Student student) {
        int a = studentMapper.add(student);//声明并定义一个类
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
    public List<Student> findA11() {
        return studentMapper.findA11();
    }
}
