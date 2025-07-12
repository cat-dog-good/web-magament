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

    /*
    //获取员工总记录数
    @Select("select count(*) from emp")
    public Long count();

    //分页查询获取列表数据
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);
     */

    //分页条件查询(利用pageHelper插件)
    @Select("select * from emp where gender = #{gender}")
    List<Emp> list1(String gender);

    //根据id删除员工信息
    @Delete("delete from emp where id=#{id}")
    int deleteById(Integer id);

    //添加删除员工信息
    @Insert("insert into emp values (#{id},#{workNo},#{name},#{gender},#{age},#{idCard})")
    void insert(Emp emp);

    //根据id查询员工信息
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    //根据用户名和密码查询用户
    @Select("select * from emp where name= #{name} and idCard=#{idCard}")
    Emp getByUsernameAndIdCard(Emp emp);
}
