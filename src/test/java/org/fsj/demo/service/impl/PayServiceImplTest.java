package org.fsj.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.dto.OrderDTO;
import org.fsj.demo.service.OrderService;
import org.fsj.demo.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws  Exception{
        OrderDTO orderDTO = new OrderDTO();
       orderDTO= orderService.findOne("1517987094359115967");
        payService.create(orderDTO);
    }
}