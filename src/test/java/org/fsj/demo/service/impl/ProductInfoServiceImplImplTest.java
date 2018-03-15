package org.fsj.demo.service.impl;

import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wxy on 2018-2-1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void testModifyAllCategoryType() {
        productInfoService.modifyAllCategoryType(3,7);
        return ;
    }


    @Test
    public void testFindOne() throws Exception {
        ProductInfo one = productInfoService.findOne("123456");
        Assert.assertNotNull(one);
    }

    @Test
    public void testFindUpAll() throws Exception {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void testFindAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345678");
        productInfo.setProductName("基围虾");
        productInfo.setProductPrice(new BigDecimal(4000.99));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一个好吃的东西");
        productInfo.setProductIcon("http://xx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(3);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}