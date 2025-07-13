package org.example.webmagament.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.webmagament.POJO.Emp;
import org.example.webmagament.POJO.Result;
import org.example.webmagament.service.EmpService;
import org.example.webmagament.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录: {}", emp);
        Emp e = empService.login(emp);

        //登录成功,生成令牌,下发令牌
        if (e != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());

            String jwt = JwtUtils.gengerateJwt(claims);//jwt包含了当前登录的员工信息
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }
}
