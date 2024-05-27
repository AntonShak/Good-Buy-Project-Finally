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
                .vendorCode(from.getVendorCode())
                .name(from.getName())
                .description(from.getDescription())
                .price(from.getPrice())
                .discount(from.getDiscount())
                .customer(from.getCustomer().getLastname())
                .marketplace(from.getMarketplace().getName())
                .build();
    }
}
