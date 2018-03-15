package org.fsj.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.dataobject.OrderDetail;
import org.fsj.demo.dto.OrderDTO;
import org.fsj.demo.enums.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    public static final String OPEN_ID = "110110";

    @Autowired
    private  OrderServiceImpl orderService;


    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("深圳市");
        orderDTO.setBuyerName("大帅哥");
        orderDTO.setBuyerPhone("110");
        orderDTO.setBuyerOpenid(OPEN_ID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1234567");
        o1.setProductQuantity(40);
        orderDetailList.add(o1);

        OrderDetail  o2= new OrderDetail();
        o2.setProductId("12345678");
        o2.setProductQuantity(60);
        orderDetailList.add(o2);

        orderDTO.setOrderDetails(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}" , result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1517988271063820091");
        log.info("orderDTO={}",orderDTO);
        Assert.assertNotEquals(0,orderDTO.getOrderDetails());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
       // Page<OrderDTO> list = orderService.findList(OPEN_ID, request);
        Page<OrderDTO> list = orderService.findList(OPEN_ID, request);
        log.info("list={}",list);
        Assert.assertNotEquals(0,list.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1517988271063820091");
        OrderDTO list = orderService.cancel(orderDTO);
        log.info("list={}",list);
        Assert.assertEquals(OrderStatus.CANCEL.getCode(),list.getOrderStatus());

    }

    @Test
    public void finish( ) {
        OrderDTO orderDTO = orderService.findOne("1517987387260165140");
        OrderDTO finish = orderService.finish(orderDTO);
        log.info("list={}",finish);
        Assert.assertEquals(OrderStatus.FINISHED.getCode(),finish.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1517986012434561126");
        OrderDTO finish = orderService.paid(orderDTO);
        log.info("list={}",finish);
        Assert.assertEquals(OrderStatus.FINISHED.getCode(),finish.getOrderStatus());
    }
}