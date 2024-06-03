package com.shakov.goodbuyproject.database.repository;

import com.shakov.goodbuyproject.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
