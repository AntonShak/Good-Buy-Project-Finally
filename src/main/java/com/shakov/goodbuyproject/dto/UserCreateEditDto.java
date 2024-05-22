package com.shakov.goodbuyproject.dto;

import com.shakov.goodbuyproject.database.entity.Role;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@Builder
@FieldNameConstants
public class UserCreateEditDto {

    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    String phone;
    Role role;
}
