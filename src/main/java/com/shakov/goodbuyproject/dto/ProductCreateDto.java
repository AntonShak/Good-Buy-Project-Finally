package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductCreateDto {

    String customer;
    String marketplace;
    String link;
    Integer discount;
    String name;
    String description;
    Double price;
    String imageLink;

}
