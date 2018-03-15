package org.fsj.demo.controller;

import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.dto.OrderDTO;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.exception.SellException;
import org.fsj.demo.service.OrderService;
import org.fsj.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 */
@Controller
@Slf4j
@RequestMapping("/map")
public class PayController {

    @Autowired
    OrderService orderService;

    @Autowired
    private PayService payService;

    /**
     * 发起支付
     * @param orderId
     * @param returnUrl
     * @param map
     * @return
     */
    @GetMapping("create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String,Object> map){
        //1.查询订单
        OrderDTO one = orderService.findOne(orderId);
        if( one == null){
           log.error("【创建订单】,订单为空");
           throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
       }
       //发起支付
        PayResponse payResponse = payService.create(one);

        map.put("payResponse",payResponse);
        return new ModelAndView("pay/create",map);
    }

    /**
     * 接受微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);

        //返回给微信处理结果
        return  new ModelAndView("pay/success");
    }
}
