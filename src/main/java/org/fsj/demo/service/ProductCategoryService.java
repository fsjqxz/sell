package org.fsj.demo.service;

import org.fsj.demo.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by wxy on 2018-1-31.
 */
public interface ProductCategoryService {
    List<Integer> findAllCategoryTypeExceptMe(Integer categoryType,Boolean isNew);

    boolean isOnlyType(Integer oldCategoryType,Integer newCategoryType,Boolean isNew);

    ProductCategory findOne(Integer CategoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
