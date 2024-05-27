package com.shakov.goodbuyproject.mapper;

import com.shakov.goodbuyproject.database.entity.Marketplace;
import com.shakov.goodbuyproject.dto.MarketplaceReadCreateEditDto;
import org.springframework.stereotype.Component;

@Component
public class MarkeplaceReadDtoMapper implements Mapper<Marketplace, MarketplaceReadCreateEditDto> {

    @Override
    public MarketplaceReadCreateEditDto map(Marketplace from) {
        return new MarketplaceReadCreateEditDto(from.getName());
    }
}
