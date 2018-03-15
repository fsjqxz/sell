package org.fsj.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.dto.OrderDTO;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.exception.SellException;
import org.fsj.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端订单
 */
@Controller
@Slf4j
@RequestMapping("/seller/order")
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @param page 第几页开始
     * @param size  一页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page" ,defaultValue = "1") Integer page,
                             @RequestParam(value = "size" ,defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1, size);
        Page<OrderDTO> list = orderService.findList(pageRequest);
        map.put("orderDTOPage",list);
        map.put("currentPage",page);
        map.put("currentSize",size);
        return new ModelAndView("order/list",  map);
    }

    @GetMapping("cancel")
    public  ModelAndView cancel(@RequestParam("orderId") String orderId,
                                Map<String,Object> map){
        try{
            OrderDTO one = orderService.findOne(orderId);
            orderService.cancel(one);
        }catch (SellException e){
            log.error("【卖家端取消订单】发送异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("detail")
    public  ModelAndView detail(@RequestParam("orderId") String orderId,
                                Map<String,Object> map){
        OrderDTO one;
        try{
            one = orderService.findOne(orderId);
        }catch (SellException e){
            log.error("【卖家端查询订单】发送异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        map.put("orderDTO",one);
        return new ModelAndView("common/detail",map);
    }

    @GetMapping("finish")
    public  ModelAndView finish(@RequestParam("orderId") String orderId,
                                Map<String,Object> map){
        try{
            OrderDTO one = orderService.findOne(orderId);
            OrderDTO finish = orderService.finish(one);
            map.put("msg",ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/success",map);
        }catch (SellException e){
            log.error("【完结订单】发送异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

    }
}
