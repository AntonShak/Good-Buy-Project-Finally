package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Product;
import com.shakov.goodbuyproject.dto.ProductReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductReadDtoMapper implements Mapper<Product, ProductReadDto> {


    @Override
    public ProductReadDto map(Product from) {

        return ProductReadDto.builder()
                .id(from.getId())
                .link(from.getLink())
                .name(from.getName())
                .description(from.getDescription())
                .price(from.getPrice())
                .discount(from.getDiscount())
                .customer(from.getCustomer().getUsername())
                .marketplace(from.getMarketplace().getName())
                .build();
    }
}
