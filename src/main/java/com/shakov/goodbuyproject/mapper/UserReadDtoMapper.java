package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.User;
import com.shakov.goodbuyproject.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadDtoMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return UserReadDto.builder()
                .id(object.getId())
                .username(object.getUsername())
                .birthDate(object.getBirthDate())
                .firstname(object.getFirstname())
                .lastname(object.getLastname())
                .phone(object.getPhone())
                .role(object.getRole())
                .build();
    }
}
