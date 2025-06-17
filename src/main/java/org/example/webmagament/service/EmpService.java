package org.example.webmagament.service;

import org.example.webmagament.POJO.Emp;

import java.util.List;

public interface EmpService {

    //查询全部员工信息
    List<Emp> list();

    //根据id员工信息
    int delete(Integer id);

    //添加员工信息
    void add(Emp emp);
}
