package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.LinkPermission;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://ebay.com");
        //get source code
       // System.out.println(driver.getPageSource());

        WebElement myEbayLink = driver.findElement(By.linkText("My eBay"));
        String classValue = myEbayLink.getAttribute("class");
        System.out.println("classValue = " + classValue);

        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon");
        System.out.println(myEbayLink.getAttribute("outerHTML"));
        System.out.println(input.getAttribute("outerHTML"));
    }
}
