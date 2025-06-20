package org.example.webmagament.service;

import org.example.webmagament.POJO.Emp;
import org.example.webmagament.POJO.PageBean;

import java.util.List;

public interface EmpService {

    //查询全部员工信息
    List<Emp> list();

    //根据id删除员工信息
    int delete(Integer id);

    //添加员工信息
    void add(Emp emp);

    //分页查询员工信息
    PageBean page(Integer page, Integer pageSize,String gender);

    //根据id查询员工信息
    Emp getById(Integer id);
}
