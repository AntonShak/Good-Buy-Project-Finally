package com.shakov.goodbuyproject.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users_marketplace")
public class UserMarketplace implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id")
    private Marketplace marketplace;

    public void setUser(User user) {
        this.user = user;
        this.user.getUserMarketplaces().add(this);
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
        this.marketplace.getUserMarketplaces().add(this);
    }
}
