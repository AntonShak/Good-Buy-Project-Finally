package com.shakov.goodbuyproject.html.connection;

import com.shakov.goodbuyproject.html.exception.ConnectionException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Connection {

    public static Document getHtmlPage(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new ConnectionException(String.format("Can't get data from url %s. Reason: %s", url, e.getMessage()));
        }
    }
}
