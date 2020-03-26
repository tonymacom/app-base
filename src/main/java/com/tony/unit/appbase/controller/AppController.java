package com.tony.unit.appbase.controller;

import com.tony.unit.appbase.client.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/26
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@RestController
public class AppController {

    @Autowired
    DemoClient demoClient;


    public String getInfo() {
        return demoClient.getInfo().toString();
    }

}
