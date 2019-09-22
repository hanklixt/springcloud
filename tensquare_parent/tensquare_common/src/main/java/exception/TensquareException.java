package exception;

import lombok.Getter;
import util.IdWorker;

@Getter
public class TensquareException extends Exception {

    private String message;
    private Integer code;

    public TensquareException(String message){
        super(message);
        this.message=message;
    }
    public TensquareException(String message,Integer code){
        super(message);
        this.message=message;
        this.code=code;
    }




}
