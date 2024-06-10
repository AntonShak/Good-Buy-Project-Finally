package com.shakov.goodbuyproject.html.scrapper.jsoup;

import org.jsoup.nodes.Document;

public interface JsoupScrapper {

        Double getPrice(Document htmlPage);

        String getName(Document htmlPage);

        String getDescription(Document htmlPage);

        String getImageLink(Document htmlPage);
    }


