package org.fsj.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wxy on 2018-2-5.
 */

@AllArgsConstructor
@Getter
public enum  OrderStatus implements CodeEnum{
    NEW(0,"新下单"),
    FINISHED(1,"已完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String msg;

/*    public static OrderStatus getOrderStatusEnum(Integer code){
        for (OrderStatus orderStatus:OrderStatus.values()){
            if (orderStatus.getCode().equals(code)){
                return orderStatus;
            }
        }
        return null;
    }*/

}
