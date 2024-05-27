package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.database.entity.Marketplace;
import com.shakov.goodbuyproject.database.repository.MarketplaceRepository;
import com.shakov.goodbuyproject.dto.MarketplaceReadDto;
import com.shakov.goodbuyproject.mapper.MarkeplaceReadDtoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class MarketplaceServiceTest {

    private static final Long MARKETPLACE_ID = 1L;

    @Mock
    private MarketplaceRepository marketplaceRepository;
    @Mock
    private MarkeplaceReadDtoMapper markeplaceReadDtoMapper;
    @InjectMocks
    private MarketplaceService marketplaceService;

    @Test
    void findById() {
        doReturn(Optional.of(new Marketplace(MARKETPLACE_ID, "Wildberries", Collections.emptyList())))
                .when(marketplaceRepository).findById(MARKETPLACE_ID);

        doReturn(new MarketplaceReadDto("Wildberries"))
                .when(markeplaceReadDtoMapper)
                .map(new Marketplace(MARKETPLACE_ID, "Wildberries", Collections.emptyList()));

        Optional<MarketplaceReadDto> actualResult = marketplaceService.findById(MARKETPLACE_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new MarketplaceReadDto("Wildberries");

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}