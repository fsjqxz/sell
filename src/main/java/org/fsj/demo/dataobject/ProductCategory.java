package org.fsj.demo.dataobject;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by wxy on 2018-1-30.
 * product_category
 */
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
//    类目id
    @Id
    @GeneratedValue
    private Integer categoryId;
//    类目名字
    private String categoryName;
//    类目编号
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;

    public  ProductCategory(String categoryName,Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
