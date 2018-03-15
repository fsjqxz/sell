package org.fsj.demo.dao;

import org.fsj.demo.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wxy on 2018-2-1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {


    @Autowired
     private  ProductInfoDao productInfoDao;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("平板电脑");
        productInfo.setProductPrice(new BigDecimal(4000.99));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("这是一个好东西");
        productInfo.setProductIcon("http://xx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}