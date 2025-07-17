package org.example.webmagament.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeAspect {

    //抽取的切入点表达式
    @Pointcut("execution(* org.example.webmagament.service.*.*(..))")
    private void pt(){
    }

    @Before("pt()")
    public void before(){
        log.info("-----------------前置通知方法运行成功");
    }

    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.记录开始时间
        long begin = System.currentTimeMillis();

        //2.调用原始方法运行
        Object result = joinPoint.proceed();

        //3.记录结束时间,计算方法耗时
        long end = System.currentTimeMillis();

        log.info("执行方法为:"+joinPoint.getSignature());
        log.info("Time taken: {} ms", end - begin);

        return result;
    }

    @After("pt()")//切入点表达式
    public void after(){
        log.info("-----------------后置通知方法运行成功");
    }

    @AfterReturning("pt()")//切入点表达式
    public void afterReturning(){
        log.info("-----------------返回后通知方法运行成功");
    }

    @AfterThrowing("pt()")//切入点表达式
    public void afterThrowing(){
        log.info("-----------------异常后通知运行成功");
    }
}
