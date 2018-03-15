package org.fsj.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.converter.OrderForm2OrderDTOConverter;
import org.fsj.demo.dto.OrderDTO;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.exception.SellException;
import org.fsj.demo.form.OrderForm;
import org.fsj.demo.service.BuyerService;
import org.fsj.demo.service.OrderService;
import org.fsj.demo.util.ResultUtil;
import org.fsj.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单的Controller
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm,
                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = new OrderDTO();
        orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())){
            log.error("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        orderService.create(orderDTO);
        return ResultUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO find(@RequestParam("openid") String openid,
                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> list = orderService.findList(openid, request);

        return ResultUtil.success(list.getContent());
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){

        OrderDTO one = buyerService.findOrderOne(openid, orderId);
        return ResultUtil.success(one);
    }
    //取消订单
    @GetMapping("/cancle")
    public ResultVO cancle(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        OrderDTO cancel = buyerService.cancelOrder(openid, orderId);
        return ResultUtil.success(cancel);
    }
}
