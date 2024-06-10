package com.shakov.goodbuyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootApplication
public class GoodBuyProjectApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(GoodBuyProjectApplication.class, args);
//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("https://ozon.by/product/spinning-zetrix-solver-sls-862m-8-32g-pe0-8-1-7-526140674/?_bctx=CAYQz4Vb&asb=Poys5obblvbEt8TF00reev48Vl%252BfJVROgj3Q6sWCzpA%253D&asb2=6kCgOPxzwJgPxwnWCgDsWKcR-e5CQHJTNfhBU47olgpU-Ql6Jg9QZ9S11jG3toihkudGwTd3rrYS1TFxwHGW1g&avtc=1&avte=2&avts=1717979525&keywords=zetrix+solver");
//        Thread.sleep(7000);
//        WebElement updateButton = chromeDriver.findElement(By.xpath("//*[@id=\"reload-button\"]"));
//        updateButton.click();
//        WebElement element = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[2]/div[1]/div[3]/div/div[1]/div/div/div[1]/div/div[1]/div[1]/span[1]"));
//        String text = element.getText();
//        System.out.println(text);
//
//        WebElement description = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/div/div[1]/h1"));
//        String descriptionText = description.getText();
//        System.out.println(descriptionText);
//
//        WebElement element1 = chromeDriver.findElement(By.xpath("//*[@id=\"layoutPage\"]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div/img"));
//        String src = element1.getAttribute("src");
//        System.out.println(src);
    }
}
