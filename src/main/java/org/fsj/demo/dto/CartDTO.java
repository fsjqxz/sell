package org.fsj.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CartDTO {
    /*商品id*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;
}
