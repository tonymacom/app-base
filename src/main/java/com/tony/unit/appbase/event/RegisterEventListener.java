package com.tony.unit.appbase.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/2/16
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
@Component
public class RegisterEventListener implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        log.info("register listener received "+ registerEvent.getSource());
    }
}
