package org.example.webmagament.exception;

import org.example.webmagament.POJO.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有的异常
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.error("操作失败!!");
    }
}
