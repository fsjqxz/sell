package org.fsj.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.fsj.demo.dataobject.OrderDetail;
import org.fsj.demo.enums.OrderStatus;
import org.fsj.demo.enums.PayStatus;
import org.fsj.demo.util.EnumUtil;
import org.fsj.demo.util.seriallizer.Date2Long;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认为0新下单
     **/
    private Integer orderStatus;
    /**
     * 支付状态,默认为0未支付
     **/
    private Integer payStatus;

    @JsonSerialize(using = Date2Long.class)
    private Date createTime;

    @JsonSerialize(using = Date2Long.class)
    private Date updateTime;

    /*@Transient //数据库不对应可以忽略掉，不用对应*/
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    public OrderStatus getOrderStatusEnum(Integer code) {
        return EnumUtil.getEnumByCode(code, OrderStatus.class);
    }

    @JsonIgnore
    public PayStatus getPayStatusEnum(Integer code) {
        return EnumUtil.getEnumByCode(code, PayStatus.class);
    }
}
