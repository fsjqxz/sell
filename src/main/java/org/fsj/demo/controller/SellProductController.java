package org.fsj.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.fsj.demo.converter.ProductFormToProductInfo;
import org.fsj.demo.dataobject.ProductCategory;
import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.enums.ProductStatusEnum;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.form.ProductForm;
import org.fsj.demo.service.ProductCategoryService;
import org.fsj.demo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 */
@RestController
@Slf4j
@RequestMapping("/seller/product")
public class SellProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品列表
     *
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfos = productInfoService.findAll(pageRequest);
        map.put("productInfos", productInfos);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("off_sale")
    public ModelAndView OffSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        ProductInfo productInfo = productInfoService.offSale(productId);
        if (productInfo.getProductStatus() != ProductStatusEnum.DOWN.getCode()) {
            log.error("【商品下架】修改订单状态不成功{}", productId);
            map.put("msg", ResultEnum.PRODUCT_STATUS_ERROR.getMsg());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }


    @GetMapping("on_sale")
    public ModelAndView OnSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        ProductInfo productInfo = productInfoService.OnSale(productId);
        if (productInfo.getProductStatus() != ProductStatusEnum.UP.getCode()) {
            log.error("【商品下架】修改订单状态不成功{}", productId);
            map.put("msg", ResultEnum.PRODUCT_STATUS_ERROR.getMsg());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);

    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo one = productInfoService.findOne(productId);
            map.put("productInfo", one);
        }
        //查出所以的类目
        List<ProductCategory> all = productCategoryService.findAll();
        map.put("categoryList", all);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存订单信息
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("/common/error",map);

        }
        ProductInfo productInfo = ProductFormToProductInfo.convert(form);
        try {
            productInfoService.save(productInfo);
            map.put("msg",ResultEnum.SUCCESS.getMsg());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("/common/success",map);
        } catch (Exception e) {
            log.error("【产品保存失败，错误id】{}",productInfo.getProductId());
            e.printStackTrace();
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("/common/error",map);
        }
    }
}
