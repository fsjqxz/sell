package org.fsj.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.fsj.demo.dataobject.ProductCategory;
import org.fsj.demo.enums.ResultEnum;
import org.fsj.demo.form.CategoryForm;
import org.fsj.demo.service.ProductCategoryService;
import org.fsj.demo.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/seller/category")
public class SellCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping
    @RequestMapping("/index")
    private ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
        ProductCategory one ;
        if (categoryId != null){
             one = categoryService.findOne(categoryId);
             map.put("category",one);
        }
        return new ModelAndView("/category/index");
    }

    @GetMapping
    @RequestMapping("/list")
    private ModelAndView list(Map<String,Object> map){
        List<ProductCategory> all = categoryService.findAll();
        map.put("categoryList",all);
        return new ModelAndView("/category/list",map);
    }

    /**
     * 保存更新
     * @param categoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @GetMapping
    @RequestMapping("/save")
    private ModelAndView save(@Valid CategoryForm categoryForm,
                              BindingResult bindingResult,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()){
            log.error("【保存类目】校验未通过");
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("/common/error",map);
        }
        try {
            ProductCategory po = new ProductCategory();
            ProductCategory old = new ProductCategory();
            Boolean isNew = true;
            Integer oldCategoryType = null;
            Integer newCategoryType;
            BeanUtils.copyProperties(categoryForm,po);

            if (categoryForm.getCategoryId() !=  null){
                isNew = false;
                old  = categoryService.findOne(categoryForm.getCategoryId());
                oldCategoryType = old.getCategoryType();
                map.put("url","/sell/seller/category/index?categoryId="+ categoryForm.getCategoryId());
            }else {
                map.put("url","/sell/seller/category/index");
            }
            newCategoryType =categoryForm.getCategoryType();
            if (!categoryService.isOnlyType(oldCategoryType,newCategoryType,isNew)){
                map.put("msg",ResultEnum.CATEGORY_TYPE_NOT_NOLY.getMsg());
                return new ModelAndView("/common/error",map);
            }
            categoryService.save(po);
            productInfoService.modifyAllCategoryType(oldCategoryType,newCategoryType);
            map.put("msg", ResultEnum.SUCCESS.getMsg());
            map.put("url","/sell/seller/category/list");
            return new ModelAndView("/common/success",map);
        } catch (BeansException e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("/common/error",map);
        }
    }
}
