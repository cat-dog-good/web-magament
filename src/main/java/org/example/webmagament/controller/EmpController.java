package org.example.webmagament.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.webmagament.POJO.Emp;
import org.example.webmagament.POJO.PageBean;
import org.example.webmagament.POJO.Result;
import org.example.webmagament.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController//包含的@ResponseBody注解会将返回值转为JSON格式
@RequestMapping("/qill7")
public class EmpController {

    //定义一个日志记录对象->用@Slf4j注解代替
    //private static Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private  EmpService empService;

    //查询全部员工信息
    //@RequestMapping(value = "/qill7/selectAll",method = RequestMethod.GET)//指定为GET请求
    @GetMapping("/selectAll")//与上面等效
    public Result list(){
        log.info("=========查询全部员工信息============");

        //调用service查询员工信息
        List<Emp> emplist =  empService.list();

        return Result.success(emplist);
    }

    //分页查询员工信息
    @GetMapping("/selectPage")
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3") Integer pageSize){
        //@RequestParam设置请求参数默认值
        log.info("分页查询,参数:{},{}",page,pageSize);

        //调用service分页查询
        PageBean pageBean =  empService.page(page,pageSize);

        return Result.success(pageBean);
    }

    //根据id删除员工信息
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除员工信息:{}",id);

        //调用service删除员工信息
        if (empService.delete(id)==0){
            return Result.error("未成功删除");
        }
        return Result.success();
    }

    //添加员工信息
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工信息:{}",emp);

        //调用service添加员工信息
        empService.add(emp);
        return Result.success();
    }
}
