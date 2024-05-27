package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.database.repository.MarketplaceRepository;
import com.shakov.goodbuyproject.dto.MarketplaceReadCreateEditDto;
import com.shakov.goodbuyproject.mapper.MarkeplaceReadDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketplaceService {

    private final MarkeplaceReadDtoMapper markeplaceReadDtoMapper;
    private final  MarketplaceRepository marketplaceRepository;


    public Optional<MarketplaceReadCreateEditDto> findById(Long id) {
        return marketplaceRepository.findById(id)
                .map(markeplaceReadDtoMapper::map);
    }
}
