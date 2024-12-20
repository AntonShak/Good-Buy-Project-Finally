package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.User;
import com.shakov.goodbuyproject.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFromCreateEditDtoMapper implements Mapper<UserCreateEditDto, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copyInUser(object, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copyInUser(fromObject, toObject);
        return toObject;
    }

    private void copyInUser(UserCreateEditDto object, User user) {
        user.setUsername(object.getUsername());
        user.setBirthDate(object.getBirthDate());
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setPhone(object.getPhone());
        user.setRole(object.getRole());

        Optional.ofNullable(object.getRawPassword()).filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);
    }
}
