package com.shakov.goodbuyproject.integrartion.service;

import com.shakov.goodbuyproject.dto.ProductReadDto;
import com.shakov.goodbuyproject.integrartion.IntegrationTestBase;
import com.shakov.goodbuyproject.integrartion.annotation.IT;
import com.shakov.goodbuyproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class ProductServiceTest extends IntegrationTestBase {

    public static final Long COAT_ID = 2L;

    private final ProductService productService;

    @Test
    void findById() {

        Optional<ProductReadDto> actualResult = productService.findById(COAT_ID);

        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(product ->
                assertEquals("185777425", actualResult.get().getLink()));

    }
}
