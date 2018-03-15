package org.fsj.demo.exception;

import org.fsj.demo.enums.ResultEnum;

/**
 * 统一异常处理
 */

public class SellException extends RuntimeException {
    private Integer code;
    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = code;
    }
    public  SellException(int code,String msg){
        super(msg);
        this.code = code;
    }
}
