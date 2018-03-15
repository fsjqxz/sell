package org.fsj.demo.dao;

import org.fsj.demo.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wxy on 2018-1-30.
 */
@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categroyTypeList);
}
