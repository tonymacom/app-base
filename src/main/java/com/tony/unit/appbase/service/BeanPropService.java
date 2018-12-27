package com.tony.unit.appbase.service;

import com.tony.unit.appbase.prop.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/12
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
@Service
public class BeanPropService extends AbstarctService{

    public String out(String prop){
        User user = new User();
        user.setId(prop);
        User res = super.setUser(user);

        log.info(System.currentTimeMillis() + " -->输入:"+ prop + ", 输出" + res.getId() + "-" + prop.equals(res.getId()));
        return null;
    }


}
