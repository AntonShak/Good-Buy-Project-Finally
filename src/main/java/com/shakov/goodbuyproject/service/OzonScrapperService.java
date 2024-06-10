package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.dto.ProductCreateDto;
import com.shakov.goodbuyproject.html.scrapper.selenium.OzonScrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OzonScrapperService {

    private final OzonScrapper ozonScrapper;

    public void finishCreateProductCreateDto(String url, ProductCreateDto productCreateDto) {
        String[] values = ozonScrapper.getValues(url);
        productCreateDto.setPrice(Double.parseDouble(values[0]));
        productCreateDto.setName(values[1]);
        productCreateDto.setDescription(values[2]);
        productCreateDto.setImageLink(values[3]);
    }
}
