package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductReadDto {

    Long id;
    String link;
    String customer;
    String marketplace;
    String name;
    String description;
    Double price;
    Integer discount;
}
