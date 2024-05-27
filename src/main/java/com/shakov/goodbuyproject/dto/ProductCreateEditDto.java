package com.shakov.goodbuyproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCreateEditDto {

    String vendorCode;
    Integer discount;

}
