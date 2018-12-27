package com.tony.unit.appbase.controller;

import com.tony.unit.appbase.service.BeanPropService;
import com.tony.unit.base.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/12
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@RestController
public class BeanPropController {

    @Autowired
    BeanPropService beanPropService;

    @RequestMapping(value = "/test/prop")
    public ResponseData outInputString(String prop){
        ResponseData data = new ResponseData();
        data.setData(beanPropService.out(prop));
        return data;
    }

}
