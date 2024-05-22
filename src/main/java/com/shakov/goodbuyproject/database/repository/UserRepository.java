package com.shakov.goodbuyproject.database.repository;

import com.shakov.goodbuyproject.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
