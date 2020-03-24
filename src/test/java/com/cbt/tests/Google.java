package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Google {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://www.google.com/");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );

        for ( String each:searchStrs) {


        }
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).
                sendKeys(searchStrs.get(0));
        String url1 = driver.getCurrentUrl();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.className("gNO89b"));
        search.click();
        driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md'] [contains(text(), 'Java | Oracle')]")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();

        System.out.println(StringUtility.verifyEquals(url1, url));
        driver.quit();
        driver.navigate().back();




    }
}
