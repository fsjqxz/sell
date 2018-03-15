package org.fsj.demo.dao;

import org.fsj.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wxy on 2018-1-30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public  void findOne(){
       ProductCategory productCategory =  productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public  void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory result =   productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public  void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,4,7);
        List<ProductCategory> result =  productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}