package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCreateDto {

    String marketplace;
    String vendorCode;
    Integer discount;
    String name;
    String description;
    Double price;
    String imageLink;

}
