package org.example.webmagament.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.webmagament.POJO.Emp;
import org.example.webmagament.POJO.PageBean;
import org.example.webmagament.mapper.EmpMapper;
import org.example.webmagament.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return empMapper.list();
    }

    @Override
    public int delete(Integer id) {
       return empMapper.deleteById(id);
    }

    @Override
    public void add(Emp emp) {
        empMapper.insert(emp);
    }


//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1.获取总记录数
//        Long count = empMapper.count();
//
//        //2.获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;//起始索引与页码之间的关系式
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        //3.封装PageBean类对象
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize,String gender) {
        //1.设置分页参数
        PageHelper.startPage(page, pageSize);

        //2.执行查询
        List<Emp> empList = empMapper.list1(gender);

        //3.通过PageInfo获取分页数据
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);

        //4.封装PageBean类对象
        PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndIdCard(emp);
    }
}
