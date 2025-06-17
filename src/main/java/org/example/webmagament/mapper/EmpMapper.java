package org.example.webmagament.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.webmagament.POJO.Emp;

import java.util.List;

@Mapper//在运行时，会自动生成该接口的实现类对象，并且将该对象交给IOC容器管理
public interface EmpMapper {

    //查询全部员工信息
    @Select("select * from emp")
    List<Emp> list();
}
