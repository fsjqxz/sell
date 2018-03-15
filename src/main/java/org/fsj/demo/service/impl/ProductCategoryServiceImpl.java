package org.fsj.demo.service.impl;

import org.fsj.demo.dao.ProductCategoryDao;
import org.fsj.demo.dataobject.ProductCategory;
import org.fsj.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类目
 * Created by wxy on 2018-1-31.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<Integer> findAllCategoryTypeExceptMe(Integer categoryType,Boolean isNew){
        List<ProductCategory> all = this.findAll();
        List<Integer> categoryTypes = all.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        if (!isNew){
            for(Integer i : categoryTypes){
                if (i==categoryType.intValue()){
                    categoryTypes.remove(i);
                    break;
                }
            }
        }
        /*Iterator<Integer> it = categoryTypes.iterator();
        while(it.hasNext()){
            Integer x = it.next();
            if(x == categoryType){
                it.remove();
            }
        }*/
        return categoryTypes;
    }

    @Override
    public  boolean isOnlyType(Integer oldCategoryType,Integer newCategoryType,Boolean isNew){
        List<Integer> list = null;
        if (oldCategoryType != null){
            list= this.findAllCategoryTypeExceptMe(oldCategoryType,isNew);
        }
        Boolean is = true;
        for (Integer i : list){
            if (i == newCategoryType.intValue()){
                is = false;
                break;
            }
        }
        return is;
    }

    @Override
    public ProductCategory findOne(Integer CategoryId) {
        return productCategoryDao.findOne(CategoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
