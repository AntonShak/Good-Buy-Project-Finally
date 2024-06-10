package com.shakov.goodbuyproject.html.scrapper.selenium;

import com.shakov.goodbuyproject.html.exception.SeleniumInterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Component
public class WildberriesScrapper implements SeleniumScrapper {

    @Override
    public String[] getValues(String url) {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {
            throw new SeleniumInterruptedException("Something tried to interrupt main sleep");
        }
        String[] values = new String[4];

        WebElement priceElement = chromeDriver.findElement(By.className("product-price-current__value"));
        String priceText = priceElement.getText();
        String price = priceText.substring(0, priceText.length() - 3).replace(",", ".");
        values[0] = price;

        WebElement description = chromeDriver.findElement(By.xpath("//*[@id=\"route-content\"]/div/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div/div/h1/span[2]"));
        String descriptionElements = description.getText();
        String[] arrayDescriptionElements = descriptionElements.split(" ");
        values[1] = arrayDescriptionElements[0];
        values[2] = descriptionElements;

        WebElement imageElement = chromeDriver.findElement(By.className("swiper-slide__img"));
        String imageLink = imageElement.getAttribute("src");
        values[3] = imageLink;

        chromeDriver.quit();

        return values;
    }
}


