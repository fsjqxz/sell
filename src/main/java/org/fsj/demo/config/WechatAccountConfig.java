package org.fsj.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties (prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 开放平台id
     */

    private  String  openAppId;
    private String openAppSecret;
    //公众号appId
    private String myAppId;
    //公众号appSecret
    private String myAppSecret;
    //商户号
    private String mchId;
    //商户秘钥
    private String mchKey;
    //商户证书路径
    private String keyPath;
    //微信证书路径
    private String notifyUrl;
}
