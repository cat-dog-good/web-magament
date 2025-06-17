package org.example.webmagament.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.webmagament.POJO.Emp;
import org.example.webmagament.POJO.Result;
import org.example.webmagament.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController//包含的@ResponseBody注解会将返回值转为JSON格式
public class EmpController {

    //定义一个日志记录对象->用@Slf4j注解代替
    //private static Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private  EmpService empService;

    //查询全部员工信息
    //@RequestMapping(value = "/qill7",method = RequestMethod.GET)//指定为GET请求
    @GetMapping("/qill7")//与上面等效
    public Result list(){
        log.info("=========查询全部员工信息============");

        //调用service查询员工信息
        List<Emp> emplist =  empService.list();

        return Result.success(emplist);
    }

    //根据id删除员工信息
    @DeleteMapping("/qill7/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除员工信息:{}",id);

        //调用service删除员工信息
        if (empService.delete(id)==0){
            return Result.error("未成功删除");
        }
        return Result.success();
    }
}
