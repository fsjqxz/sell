package org.fsj.demo.service.impl;

import org.fsj.demo.dao.ProductInfoDao;
import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.dto.CartDTO;
import org.fsj.demo.enums.ProductStatusEnum;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.exception.SellException;
import org.fsj.demo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wxy on 2018-2-1.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public void modifyAllCategoryType(Integer oldCategoryType,Integer newCategoryType){
        List<ProductInfo> productInfos = productInfoDao.findByCategoryType(oldCategoryType);
        for(ProductInfo productInfo : productInfos){
            productInfo.setCategoryType(newCategoryType);
            productInfoDao.save(productInfo);
        }
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo one = productInfoDao.findOne(cartDTO.getProductId());
            if (one == null ){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = one.getProductStock() + cartDTO.getProductQuantity();
            one.setProductStock(result);
            productInfoDao.save(one);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo one = productInfoDao.findOne(cartDTO.getProductId());
            if (one == null ){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            if (one.getProductStock() < cartDTO.getProductQuantity()){
                throw  new SellException(ResultEnum.PRODUCT_NOT_ENOUGH);
            }else{
                Integer result = one.getProductStock() - cartDTO.getProductQuantity();
                one.setProductStock(result);
                productInfoDao.save(one);
            }
        }
    }

    @Override
    public ProductInfo OnSale(String productId) {
        ProductInfo one = productInfoDao.findOne(productId);
        if (one == null){
            throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        one.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoDao.save(one);
        return one;
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo one = productInfoDao.findOne(productId);
        if (one == null){
            throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        one.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfoDao.save(one);
        return one;
    }
}
