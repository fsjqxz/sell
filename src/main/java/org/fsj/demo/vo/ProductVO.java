package org.fsj.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含内幕
 * Created by wxy on 2018-2-1.
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private  String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO>  productVOList;
}
