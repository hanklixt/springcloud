package com.tensquare.spit.base.exception;

import entity.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import resultenum.ResultEnum;
import util.HttpResultUtils;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        //todo 细分异常
       return HttpResultUtils.error(ResultEnum.INNER_ERROR);
    }
}
