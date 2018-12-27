package com.tony.unit.appbase.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/1
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Data
@Component
@ConfigurationProperties
@PropertySource(value = {"classpath:config_third.properties"})
public class ThridProps {

    private WechatProp wechat;

    @Data
    @Component
    public static class WechatProp{
        private String web_key;
        private String web_secret;
    }

}
