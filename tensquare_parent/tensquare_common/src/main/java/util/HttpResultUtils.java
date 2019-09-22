package util;

import entity.Result;
import lombok.experimental.UtilityClass;
import resultenum.ResultEnum;

@UtilityClass
public class HttpResultUtils {
    public Result success(Object object){

        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS_CODE.getCode());
        result.setMessage(ResultEnum.SUCCESS_CODE.getMessage());
        result.setData(object);
        result.setFlag(true);
        return result;
    }
    public Result error(Object object,ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setData(object);
        result.setFlag(false);
        return result;
    }

    public Result error(Integer code,String message){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setFlag(false);
        return result;
    }

    public Result success(){

        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS_CODE.getCode());
        result.setMessage(ResultEnum.SUCCESS_CODE.getMessage());
        result.setFlag(true);
        return result;
    }
    public Result error(ResultEnum resultEnum){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setFlag(false);
        return result;
    }
}
