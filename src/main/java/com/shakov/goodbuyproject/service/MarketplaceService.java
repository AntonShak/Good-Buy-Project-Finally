package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.database.repository.MarketplaceRepository;
import com.shakov.goodbuyproject.dto.MarketplaceReadCreateEditDto;
import com.shakov.goodbuyproject.mapper.MarkeplaceReadDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketplaceService {

    private final MarkeplaceReadDtoMapper markeplaceReadDtoMapper;
    private final  MarketplaceRepository marketplaceRepository;


    public List<MarketplaceReadCreateEditDto> findAll() {
        return marketplaceRepository.findAll().stream()
                .map(markeplaceReadDtoMapper::map)
                .toList();
    }

    public Optional<MarketplaceReadCreateEditDto> findById(Long id) {
        return marketplaceRepository.findById(id)
                .map(markeplaceReadDtoMapper::map);
    }
}
