package org.fsj.demo.service.impl;

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
 * Created by wxy on 2018-1-31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl categoryService;


    @Test
    public void testFindAllCategoryType(){
        List<Integer> exceptMe = categoryService.findAllCategoryTypeExceptMe(2,true);
        Assert.assertNotNull(exceptMe);
    }

    @Test
    public void testFindOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void testFindAll() throws Exception {
        List<ProductCategory> categoryServiceAll = categoryService.findAll();
        Assert.assertNotEquals(0,categoryServiceAll.size());
    }

    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(2,4,7);
        List<ProductCategory> categoryTypeIn = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,categoryTypeIn.size());
    }

    @Test
    public void testSave() throws Exception {
        ProductCategory productCategory = new ProductCategory("男生专享", 10);
        ProductCategory save = categoryService.save(productCategory);
        Assert.assertNotNull(save);
    }
}