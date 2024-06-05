package com.shakov.goodbuyproject.integrartion.service;

import com.shakov.goodbuyproject.database.entity.Role;
import com.shakov.goodbuyproject.dto.UserCreateEditDto;
import com.shakov.goodbuyproject.dto.UserReadDto;
import com.shakov.goodbuyproject.integrartion.IntegrationTestBase;
import com.shakov.goodbuyproject.integrartion.annotation.IT;
import com.shakov.goodbuyproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserServiceTest extends IntegrationTestBase  {

    public static final Long ANTON_ID = 1L;

    private final UserService userService;

    @Test
    void findById() {
        Optional<UserReadDto> actualResult = userService.findById(ANTON_ID);

        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> assertEquals("Anton", actualResult.get().getFirstname()));
    }

    @Test
    void create() {
        UserCreateEditDto userCreateEditDto = createUserCreateEditDto();

        UserReadDto actualResult = userService.create(userCreateEditDto);

        assertEquals(userCreateEditDto.getUsername(), actualResult.getUsername());
        assertEquals(userCreateEditDto.getFirstname(), actualResult.getFirstname());
        assertEquals(userCreateEditDto.getLastname(), actualResult.getLastname());
        assertEquals(userCreateEditDto.getBirthDate(), actualResult.getBirthDate());
        assertEquals(userCreateEditDto.getPhone(), actualResult.getPhone());
        assertEquals(userCreateEditDto.getRole(), actualResult.getRole());
        assertEquals(3L, actualResult.getId());


    }

    private static UserCreateEditDto createUserCreateEditDto() {
        return UserCreateEditDto.builder()
                .username("test@gmail.com")
                .rawPassword("test")
                .firstname("Test")
                .lastname("Test")
                .birthDate(LocalDate.now())
                .phone("+3752916547922")
                .role(Role.ADMIN).build();
    }
}
