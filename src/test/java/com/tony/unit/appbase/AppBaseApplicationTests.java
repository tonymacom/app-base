package com.tony.unit.appbase;

import com.tony.unit.appbase.service.BeanPropService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppBaseApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    BeanPropService beanPropService;


    @Test
    public void beanoutTest(){

        for (int i = 0; i < 100; i++) {
            final String prop = i+"";
            new Thread(new Runnable(){

                @Override
                public void run() {
                    beanPropService.out(prop);
                }
            }).start();

        }

    }

}
