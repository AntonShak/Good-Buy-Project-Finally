package com.shakov.goodbuyproject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoodBuyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodBuyProjectApplication.class, args);

//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("https://www.wildberries.by/product?card=185777425");
//        WebElement element = chromeDriver.findElement(By.cssSelector("//span[@class='product-price-current__value']"));
//        String text = element.getText();
//        System.out.println(text);
    }

}
