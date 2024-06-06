package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductEditDto {

    Integer discount;
    String name;
    String description;

}
