package org.fsj.demo.service;

import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wxy on 2018-2-1.
 */

public interface ProductInfoService {

    void modifyAllCategoryType(Integer oldCategoryType,Integer newCategoryType);

    ProductInfo findOne(String productId);
//    查询在架的商品列表
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
    //上架
    ProductInfo OnSale(String productId);
    //下架
    ProductInfo offSale(String productId);


}
