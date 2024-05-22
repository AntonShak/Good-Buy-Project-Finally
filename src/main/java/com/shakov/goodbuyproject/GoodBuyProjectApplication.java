package com.shakov.goodbuyproject;

import com.shakov.goodbuyproject.dto.MarketplaceReadDto;
import com.shakov.goodbuyproject.dto.UserReadDto;
import com.shakov.goodbuyproject.service.MarketplaceService;
import com.shakov.goodbuyproject.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class GoodBuyProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GoodBuyProjectApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        List<UserReadDto> all = userService.findAll();

        System.out.println(all);
    }

}
