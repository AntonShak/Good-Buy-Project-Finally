package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Product;
import com.shakov.goodbuyproject.dto.ProductCreateEditDto;
import org.springframework.stereotype.Component;

@Component
public class ProductFromCreateEditDtoMapper implements Mapper<ProductCreateEditDto, Product> {
    @Override
    public Product map(ProductCreateEditDto from) {
        return Product.builder()
                .vendorCode(from.getVendorCode())
                .discount(from.getDiscount()).build();
    }
}
