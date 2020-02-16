package com.tony.unit.appbase.controller;

import com.tony.unit.appbase.service.RegisterService;
import com.tony.unit.base.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/2/16
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@RestController
public class EventPublisherController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(path ="/publish", method = RequestMethod.GET)
    public ResponseData publish(String name) {
        registerService.register(name);
        return ResponseData.SUCCESS;
    }
}
