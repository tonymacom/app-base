package com.tony.unit.appbase.service;

import com.tony.unit.appbase.prop.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2018/12/12
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public abstract class AbstarctService {

    public User setUser(User user){
        User user_super = user;
        return user_super;
    }


}
