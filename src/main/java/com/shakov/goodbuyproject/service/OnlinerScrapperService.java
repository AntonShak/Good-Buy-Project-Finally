package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.dto.ProductCreateDto;
import com.shakov.goodbuyproject.html.connection.Connection;
import com.shakov.goodbuyproject.html.scrapper.OnlinerScrapper;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnlinerScrapperService {


    private final OnlinerScrapper onlinerScrapper;

    public void finishCreateProductCreateDto(String url, ProductCreateDto productCreateDto) {

        Document htmlPage = Connection.getHtmlPage(url);
        productCreateDto.setName(onlinerScrapper.getName(htmlPage));
        productCreateDto.setDescription(onlinerScrapper.getDescription(htmlPage));
        productCreateDto.setPrice(onlinerScrapper.getPrice(htmlPage));
        productCreateDto.setImageLink(onlinerScrapper.getImageLink(htmlPage));
    }
}
