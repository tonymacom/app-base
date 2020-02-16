package com.tony.unit.appbase.service;

import com.tony.unit.appbase.event.RegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/2/16
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
@Service
public class RegisterService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void register(String name) {
        log.info("register success, name is "+ name + ", and publish event");
        publisher.publishEvent(new RegisterEvent(name));
    }
}
