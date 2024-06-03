package com.shakov.goodbuyproject.dto;

import com.shakov.goodbuyproject.database.entity.Role;
import com.shakov.goodbuyproject.validation.groups.CreateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(groups = CreateAction.class)
    String rawPassword;

    LocalDate birthDate;

    @NotBlank
    @Size(min = 2, max = 64)
    String firstname;

    @NotBlank
    @Size(min = 2, max = 64)
    String lastname;

    @NotBlank
    String phone;

    Role role;
}
