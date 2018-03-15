package org.fsj.demo.service.impl;

import org.fsj.demo.dao.SellerInfoDao;
import org.fsj.demo.dataobject.SellerInfo;
import org.fsj.demo.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByUsername(String username) {
        return sellerInfoDao.findByUsername(username);
    }
}
