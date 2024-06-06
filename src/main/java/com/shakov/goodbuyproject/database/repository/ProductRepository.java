package com.shakov.goodbuyproject.database.repository;

import com.shakov.goodbuyproject.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p  FROM Product p join fetch p.customer pc where pc.username = :username")
    List<Product> findAllProductsByUsername(String username);
}

