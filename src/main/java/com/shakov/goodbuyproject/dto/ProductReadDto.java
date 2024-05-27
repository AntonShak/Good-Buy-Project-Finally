package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductReadDto {

    String vendorCode;
    String customer;
    String marketplace;
    String name;
    String description;
    Double price;
    Integer discount;
}
