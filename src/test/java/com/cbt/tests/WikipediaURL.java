package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class WikipediaURL {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='search']")).
                sendKeys("selenium webdriver");
        driver.findElement(By.xpath
                ("//button[@class='pure-button pure-button-primary-progressive']")).click();
         driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[3]/ul/li/div/a")).click();

         String url = driver.getCurrentUrl();
         String ends = "Selenium_(software)";

         boolean var = url.contains(ends);
         System.out.println("var = " + var);
         driver.close();

    }
}
