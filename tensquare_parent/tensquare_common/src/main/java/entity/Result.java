package entity;

import lombok.Data;

@Data
public class Result {
    private String message;
    private Boolean flag;
    private Object data;
    private Integer code;
}
