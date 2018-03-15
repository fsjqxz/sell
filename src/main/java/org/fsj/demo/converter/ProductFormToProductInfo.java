package org.fsj.demo.converter;

import org.apache.commons.lang3.StringUtils;
import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.enums.ProductStatusEnum;
import org.fsj.demo.form.ProductForm;
import org.fsj.demo.util.KeyUtil;

public  class ProductFormToProductInfo {

    public static ProductInfo convert(ProductForm productForm){

        ProductInfo productInfo = new ProductInfo();
        if (StringUtils.isEmpty(productForm.getProductId())){
            productInfo.setProductId(KeyUtil.genUniquKey());
            productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        } else{
            productInfo.setProductId(productForm.getProductId());
        }
        productInfo.setProductName(productForm.getProductName());
        productInfo.setProductPrice(productForm.getProductPrice());
        productInfo.setProductDescription(productForm.getProductDescription());
        productInfo.setProductStock(productForm.getProductStock());
        productInfo.setProductIcon(productForm.getProductIcon());
        productInfo.setCategoryType(productForm.getCategoryType());
        //BeanUtils.copyProperties(productForm,productInfo);
        return productInfo;
    }

}
