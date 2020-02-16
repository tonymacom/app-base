package com.tony.unit.appbase.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/2/16
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Component
public class RegisterListeners2 {

    @EventListener
    public void getUserEvent(RegisterEvent registerEvent) {
        System.out.println("regsiter-接受到事件：" + registerEvent.getSource());
    }
}
