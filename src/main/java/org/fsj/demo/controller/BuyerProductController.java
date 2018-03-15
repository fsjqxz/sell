package org.fsj.demo.controller;

import org.fsj.demo.dataobject.ProductCategory;
import org.fsj.demo.dataobject.ProductInfo;
import org.fsj.demo.service.ProductCategoryService;
import org.fsj.demo.service.ProductInfoService;
import org.fsj.demo.util.ResultUtil;
import org.fsj.demo.vo.ProductInfoVO;
import org.fsj.demo.vo.ProductVO;
import org.fsj.demo.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wxy on 2018-2-1.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;



    @GetMapping("/list")
    public ResultVO list(){
        //1.先查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询类目（一次性查询）
       /* List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //精简做法(java8,lambda)
        List<Integer> categoryTypeList  = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory :productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductVOList(productInfoVOList);
            productVOList.add(productVO);
        }




        return ResultUtil.success(productVOList);

    }


    @GetMapping("/thymeleaf")
    public String thymeleaf(ModelMap modelMap){
        ModelMap map = new ModelMap();
        ResultVO result = this.list();
        map.put("result",result);
        return  "ajax";
    }
}
