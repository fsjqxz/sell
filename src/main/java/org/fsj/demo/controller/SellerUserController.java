package org.fsj.demo.controller;


import org.fsj.demo.dataobject.SellerInfo;
import org.fsj.demo.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seller")
public class SellerUserController {

//    @Autowired
//    private RedisTe

    @Autowired
    private SellerInfoService sellerInfoService;

//    @Autowired
//    private StringRidesTemplate stringRidesTemplate;

    @GetMapping("/loginByOpenid")
    public void loginByOpenid(@RequestParam("openid") String openid){
        //1.openid去和数据库里做匹配
        SellerInfo info = sellerInfoService.findSellerInfoByOpenId(openid);
        //2.设置token值redis
        //3.设置token值cookie

    }

    @GetMapping("/login")
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password){
        //1.openid去和数据库里做匹配
        SellerInfo info = sellerInfoService.findSellerInfoByUsername(username);
        if (info == null){

        }
        //2.设置token值redis
        //3.设置token值cookie

    }
}
