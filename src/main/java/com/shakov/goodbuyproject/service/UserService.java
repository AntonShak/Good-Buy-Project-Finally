package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.database.repository.UserRepository;
import com.shakov.goodbuyproject.dto.UserCreateEditDto;
import com.shakov.goodbuyproject.dto.UserReadDto;
import com.shakov.goodbuyproject.mapper.UserFromCreateEditDtoMapper;
import com.shakov.goodbuyproject.mapper.UserReadDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserReadDtoMapper userReadDtoMapper;
    private final UserFromCreateEditDtoMapper userFromCreateEditDtoMapper;


    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadDtoMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {

        return userRepository.findById(id)
                .map(userReadDtoMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userCreateEditDto) {
        return Optional.of(userCreateEditDto)
                .map(userFromCreateEditDtoMapper::map)
                .map(userRepository::save)
                .map(userReadDtoMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userCreateEditDto) {

        return userRepository.findById(id)
                .map(entity -> userFromCreateEditDtoMapper.map(userCreateEditDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadDtoMapper::map);
    }


    @Transactional
    public boolean delete(Long id) {

        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);

    }
}
