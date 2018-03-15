package org.fsj.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wxy on 2018-2-1.
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"上架"),
    DOWN(1,"下架");

    private  Integer code;
    private  String msg;

}
