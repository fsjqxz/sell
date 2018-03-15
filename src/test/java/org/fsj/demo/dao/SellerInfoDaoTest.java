package org.fsj.demo.dao;

import org.fsj.demo.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;


    @Test
    public void  testSellerInfoDaoTest(){
        SellerInfo byOpenid = sellerInfoDao.findByOpenid("1519625975867209202");
        Assert.assertEquals(byOpenid.getOpenid(),"1519625975867209202");
    };
}