package org.fsj.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    /**
     *
     */
    public String wechatMpAuthorize;
    public String wechatOpenAuthorize;
    /**
     * 点餐系统
     */
    public String sell;
}
