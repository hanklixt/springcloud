package resultenum;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS_CODE(100,"请求成功"),
    INNER_ERROR(500,"系统错误"),
    REQUEST_PARAM_ERROR(700,"请求参数错误"),
    NOT_REPEAT(300,"您已经点过赞了");

    private Integer code;
    private String message;
    private ResultEnum (Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
