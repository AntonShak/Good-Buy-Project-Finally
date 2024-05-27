package com.shakov.goodbuyproject;


import com.shakov.goodbuyproject.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GoodBuyProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GoodBuyProjectApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        System.out.println(userService);
    }

}
