package com.shakov.goodbuyproject.database.repository;

import com.shakov.goodbuyproject.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
