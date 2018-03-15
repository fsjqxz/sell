package org.fsj.demo.form;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

    /**
     * 商品ID
     */
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;
}
