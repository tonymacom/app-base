package com.tony.unit.appbase;

import com.yamibuy.ec.core.annotation.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@SpringBootApplication
public class AppBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBaseApplication.class, args);
    }

}
