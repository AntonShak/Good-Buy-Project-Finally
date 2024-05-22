package com.shakov.goodbuyproject.dto;

import com.shakov.goodbuyproject.database.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserReadDto {

    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    String phone;
    Role role;
}
