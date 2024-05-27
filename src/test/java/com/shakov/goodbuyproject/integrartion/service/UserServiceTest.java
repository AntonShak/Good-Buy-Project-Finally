package com.shakov.goodbuyproject.integrartion.service;

import com.shakov.goodbuyproject.dto.UserReadDto;
import com.shakov.goodbuyproject.integrartion.IntegrationTestBase;
import com.shakov.goodbuyproject.integrartion.annotation.IT;
import com.shakov.goodbuyproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@IT
@RequiredArgsConstructor
public class UserServiceTest extends IntegrationTestBase  {

    public static final Long ANTON_ID = 1L;

    private final UserService userService;

    @Test
    void findById() {
        Optional<UserReadDto> actualResult = userService.findById(ANTON_ID);

        Assertions.assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> Assertions.assertEquals("Anton", actualResult.get().getFirstname()));
    }
}
