package org.example.webmagament.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.webmagament.POJO.OperateLog;
import org.example.webmagament.mapper.OperateLogMapper;
import org.example.webmagament.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect//切面类
public class LogAspect {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(org.example.webmagament.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //操作人ID -- 当前登录员工ID
        //获取请求头的JWT令牌并解析
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作的方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
    //调用原始目标方法运行
    Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //方法返回值
        String returnValue = mapper.writeValueAsString(result);

        //操作耗时
        long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("记录操作日志{}",operateLog);

        return result;
    }
}
