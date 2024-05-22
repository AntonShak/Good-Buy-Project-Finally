package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Marketplace;
import com.shakov.goodbuyproject.dto.MarketplaceReadDto;
import org.springframework.stereotype.Component;

@Component
public class MarkeplaceReadDtoMapper implements Mapper<Marketplace, MarketplaceReadDto> {

    @Override
    public MarketplaceReadDto map(Marketplace from) {
        return new MarketplaceReadDto(from.getName());
    }
}
