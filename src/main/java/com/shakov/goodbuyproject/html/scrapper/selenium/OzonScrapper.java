package com.shakov.goodbuyproject.html.scrapper.selenium;

import com.shakov.goodbuyproject.html.exception.SeleniumInterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class OzonScrapper implements SeleniumScrapper {

    @Override
    public String[] getValues(String url) {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new SeleniumInterruptedException("Something tried to interrupt main sleep");
        }
        String[] values = new String[4];
        WebElement updateButton = chromeDriver.findElement(By.xpath("//*[@id=\"reload-button\"]"));
        updateButton.click();

        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new SeleniumInterruptedException("Something tried to interrupt main sleep");
        }

        WebElement priceElement = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[2]/div[1]/div[3]/div/div[1]/div/div/div[1]/div/div[1]/div[1]/span[1]"));
        String priceText = priceElement.getText();
        String price = priceText.substring(0, priceText.length() - 5).replace(",", ".");
        values[0] = price;

        WebElement descriptionElement = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/div/div[1]/h1"));
        String descriptionElements = descriptionElement.getText();
        String[] arrayDescriptionElements = descriptionElements.split(" ");
        values[1] = arrayDescriptionElements[0];
        values[2] = descriptionElements;

        WebElement imageElement = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/img"));
        String imageLink = imageElement.getAttribute("src");
        values[3] = imageLink;

        chromeDriver.quit();

        return values;
    }
}
