package com.shakov.goodbuyproject.dto;

import com.shakov.goodbuyproject.database.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@Builder
@FieldNameConstants
public class UserCreateEditDto {

    @Email
    String username;
    LocalDate birthDate;
    @NotNull
    @Size(min = 2, max = 64)
    String firstname;
    @NotNull
    @Size(min = 2, max = 64)
    String lastname;
    @NotNull
    String phone;
    Role role;
}
