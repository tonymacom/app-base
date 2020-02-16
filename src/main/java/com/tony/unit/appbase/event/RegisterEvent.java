package com.tony.unit.appbase.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/2/16
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class RegisterEvent extends ApplicationEvent {
    public RegisterEvent(String name) {
        super(name);
    }
}
