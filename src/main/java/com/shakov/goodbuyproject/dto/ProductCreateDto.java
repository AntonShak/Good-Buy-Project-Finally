package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCreateDto {

    String vendorCode;
    Integer discount;

}
