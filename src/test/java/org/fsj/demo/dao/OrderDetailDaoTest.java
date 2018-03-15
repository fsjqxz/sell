package org.fsj.demo.dao;

import org.fsj.demo.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("111111");
        orderDetail.setProductIcon("http://xx.jsp");
        orderDetail.setProductName("鸭蛋粥");
        orderDetail.setProductId("111111");
        orderDetail.setProductQuantity(22);
        orderDetail.setProductPrice(new BigDecimal("2.3"));
        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}