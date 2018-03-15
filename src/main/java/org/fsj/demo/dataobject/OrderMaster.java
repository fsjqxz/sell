package org.fsj.demo.dataobject;

import lombok.Data;
import org.fsj.demo.enums.OrderStatus;
import org.fsj.demo.enums.PayStatus;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wxy on 2018-2-5.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private  String orderId;
    private  String buyerName;
    private  String buyerPhone;
    private  String buyerAddress;
    private  String buyerOpenid;
    private BigDecimal orderAmount;
    /**订单状态，默认为0新下单 **/
    private Integer orderStatus = OrderStatus.NEW.getCode();
    /**支付状态,默认为0未支付**/
    private Integer payStatus = PayStatus.WAIT.getCode();

    private Date createTime;
    private Date updateTime;

}
