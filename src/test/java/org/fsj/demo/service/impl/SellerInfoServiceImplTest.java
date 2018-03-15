package org.fsj.demo.service.impl;

import org.fsj.demo.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellerInfoService;

    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo info = sellerInfoService.findSellerInfoByOpenId("1519625975867209202");
        //Assert.assertEquals(info.getOpenid(),"1519625975867209202");
        Assert.assertNotNull(info);
    }
}