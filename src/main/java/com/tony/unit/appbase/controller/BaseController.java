package com.tony.unit.appbase.controller;

import com.tony.unit.appbase.prop.ThridProps;
import com.tony.unit.base.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MABO on 2017/6/27.
 */
@RestController
public class BaseController {

    @Autowired
    ThridProps thridProps;

    ThridProps.WechatProp wechatProp;


    /**
     * 这种方式不能赋值, 会报异常, 使用@PostConstruct替代
     */
    /*public BaseController(){
        wechatProp = thridProps.getWechat();
    }*/

    /**
     * 不能返回值
     * @return
     */
    @RequestMapping(value = "/output")
    public ResponseData outInputString(){
        ResponseData data = new ResponseData();
        data.setData(thridProps.getWechat().getWeb_key() + "-----" +wechatProp.getWeb_key());
        return data;
    }


}
