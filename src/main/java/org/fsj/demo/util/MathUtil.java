package org.fsj.demo.util;

public class MathUtil {

    public static final Double MoneyAbs = 0.01 ;
    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1,Double d2){
        double abs = Math.abs(d1 - d2);
        if (abs < MoneyAbs){
            return true;
        }else {
            return false;
        }
    }
}
