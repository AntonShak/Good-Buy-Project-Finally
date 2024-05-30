package com.shakov.goodbuyproject.html.scrapper;

import org.jsoup.nodes.Document;

public interface Scrapper {

        Double getPrice(Document htmlPage);

        String getName(Document htmlPage);

        String getDescription(Document htmlPage);

        String getImageLink(Document htmlPage);
    }


