package com.tony.unit.appbase.client;

import com.yamibuy.ec.core.annotation.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/26
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@FeignClient(url = "http://qc.ecapi.yamicdn.com", name = "ec-customer")
public interface DemoClient {

    @RequestMapping(value = "/ec-customer/info",method = RequestMethod.GET)
    public Object getInfo();

}
