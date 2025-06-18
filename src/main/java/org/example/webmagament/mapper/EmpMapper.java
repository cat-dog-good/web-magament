package org.example.webmagament.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.webmagament.POJO.Emp;

import java.util.List;

@Mapper//在运行时，会自动生成该接口的实现类对象，并且将该对象交给IOC容器管理
public interface EmpMapper {

    //查询全部员工信息
    @Select("select * from emp")
    List<Emp> list();

    //根据id删除员工信息
    @Delete("delete from emp where id=#{id}")
    int deleteById(Integer id);

    //添加删除员工信息
    @Insert("insert into emp values (#{id},#{workNo},#{name},#{gender},#{age},#{idCard})")
    void insert(Emp emp);

    //获取员工总记录数
    @Select("select count(*) from emp")
    public Long count();

    //分页查询获取列表数据
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);
}
