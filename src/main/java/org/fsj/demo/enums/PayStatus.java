package org.fsj.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wxy on 2018-2-5.
 */
@AllArgsConstructor
@Getter
public enum  PayStatus implements CodeEnum{
    WAIT(0,"未支付"),
    FINISHED(1,"已支付");


    private Integer code;
    private String msg;


 /*   public static PayStatus getPayStatusEnum(Integer code){
        for (PayStatus payStatus:PayStatus.values()){
            if (payStatus.getCode().equals(code)){
                return payStatus;
            }
        }
        return null;
    }*/
}
