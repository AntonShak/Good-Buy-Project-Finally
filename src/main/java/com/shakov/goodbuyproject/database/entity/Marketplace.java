package com.shakov.goodbuyproject.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "userMarketplaces")
@EqualsAndHashCode(of = "name")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marketplace implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "marketplace")
    private List<UserMarketplace> userMarketplaces = new ArrayList<>();
}
