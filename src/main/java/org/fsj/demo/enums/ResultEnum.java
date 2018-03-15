package org.fsj.demo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    ORDER_OWNER_ERROR(19,"改订单不属于当前用户"),
    CART_EMPTY(18,"购物车不能为空"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_NOT_ENOUGH(11,"商品库存不够"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    WX_MP_ERROR(20,"微信公众号方面错误"),
    READ_PRO_ERROR(21,"读取配置错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(22,"微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(23,"订单取消成功"),
    ORDER_FINISH_SUCCESS(24,"完结订单成功"),
    PRODUCT_STATUS_ERROR(25,"商品状态不正确"),
    CATEGORY_TYPE_NOT_NOLY(26,"分类type重复"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确");
    private Integer code;
    private String msg;


}
