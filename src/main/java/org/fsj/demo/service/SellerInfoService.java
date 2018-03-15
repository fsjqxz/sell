package org.fsj.demo.service;

import org.fsj.demo.dataobject.SellerInfo;

public interface SellerInfoService {

    SellerInfo findSellerInfoByOpenId(String openid);
    SellerInfo findSellerInfoByUsername(String username);
}
