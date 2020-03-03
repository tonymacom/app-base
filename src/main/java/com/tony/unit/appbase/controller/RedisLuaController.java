package com.tony.unit.appbase.controller;

import com.tony.unit.base.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/3
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@RestController
public class RedisLuaController {


    @Autowired
    RedisTemplate<String,String> redisTemplate1;

    private DefaultRedisScript<List> getRedisScript;

    @PostConstruct
    public void init() {
        getRedisScript = new DefaultRedisScript<List>();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/LimitLoadTimes.lua")));
    }




    /**
     * 接口调用redis执行lua脚本
     * @return
     */
    @RequestMapping(value = "/lua")
    public ResponseData lua(){
        ResponseData data = new ResponseData();

        /**
         * List设置lua的KEYS
         */
        List<String> keyList = new ArrayList();
        keyList.add("count");
        keyList.add("rate.limiting:127.0.0.1");

        /**
         * 用String数组设置ARGV, 这里不能用list
         */
        String[] args = new String[]{"10","30"};

        /**
         * 调用脚本并执行
         */
        List result = redisTemplate1.execute(getRedisScript,keyList, args);
        System.out.println(result);


        return data;
    }

}
