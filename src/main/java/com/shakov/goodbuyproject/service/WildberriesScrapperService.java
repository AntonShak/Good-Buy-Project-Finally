package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.dto.ProductCreateDto;
import com.shakov.goodbuyproject.html.scrapper.selenium.WildberriesScrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WildberriesScrapperService {

    private final WildberriesScrapper wildberriesScrapper;

    public void finishCreateProductCreateDto(String url, ProductCreateDto productCreateDto) {
        String[] values = wildberriesScrapper.getValues(url);
        productCreateDto.setPrice(Double.parseDouble(values[0]));
        productCreateDto.setName(values[1]);
        productCreateDto.setDescription(values[2]);
        productCreateDto.setImageLink(values[3]);
    }
}