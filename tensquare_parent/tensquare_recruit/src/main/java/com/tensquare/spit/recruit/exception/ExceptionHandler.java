package com.tensquare.spit.recruit.exception;

import entity.Result;
import exception.TensquareException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import resultenum.ResultEnum;
import util.HttpResultUtils;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        if (e instanceof TensquareException){
            TensquareException tensquareException= (TensquareException) e;
          return HttpResultUtils.error(tensquareException.getCode(),tensquareException.getMessage());
        }
        //todo 细分异常
       return HttpResultUtils.error(ResultEnum.INNER_ERROR);
    }
}
