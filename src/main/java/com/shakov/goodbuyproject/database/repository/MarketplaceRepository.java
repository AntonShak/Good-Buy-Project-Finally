package com.shakov.goodbuyproject.database.repository;

import com.shakov.goodbuyproject.database.entity.Marketplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketplaceRepository extends JpaRepository<Marketplace, Long> {
}
