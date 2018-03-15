package org.fsj.demo.util;

import org.fsj.demo.enums.CodeEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getEnumByCode(Integer code , Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
