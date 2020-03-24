package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("sanitizer");
        WebElement searchButton = driver.findElement(By.xpath("//input[@class='nav-input'][@value='Go']"));
        searchButton.click();
        String title = driver.getTitle();
        String item = "sanitizer";
        boolean var = title.contains(item);
        System.out.println("var = " + var);
        driver.quit();



    }
}
