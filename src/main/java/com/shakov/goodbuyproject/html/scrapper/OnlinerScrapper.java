package com.shakov.goodbuyproject.html.scrapper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class OnlinerScrapper implements Scrapper {


    @Override
    public Double getPrice(Document htmlPage) {
        Elements element = htmlPage.selectXpath
                ("//div[@class='offers-description__price offers-description__price_primary']/a");
        String text = element.text();
        String[] words = text.split(" ");
        return Double.parseDouble(words[0].replace(",", "."));
    }

    @Override
    public String getName(Document htmlPage) {
        Elements element = htmlPage.selectXpath("//h1[@class='catalog-masthead__title js-nav-header']");
        String text = element.text();
        String[] words = text.split(" ");
        return words[0];
    }

    @Override
    public String getDescription(Document htmlPage) {
        Elements element = htmlPage.selectXpath("//h1[@class='catalog-masthead__title js-nav-header']");
        return element.text();
    }

    @Override
    public String getImageLink(Document htmlPage) {
        Elements element = htmlPage.selectXpath("//img[@id='device-header-image']");
        return element.attr("src");
    }
}
