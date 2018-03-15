package org.fsj.demo.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.fsj.demo.enums.ProductStatusEnum;
import org.fsj.demo.util.EnumUtil;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wxy on 2018-1-31.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private  String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private  String productDescription;
    private String productIcon;
    /*0正常，1下架*/
    private  Integer productStatus = ProductStatusEnum.UP.getCode();
    /*类目编号*/
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getEnumByCode(productStatus,ProductStatusEnum.class);
    }

}
