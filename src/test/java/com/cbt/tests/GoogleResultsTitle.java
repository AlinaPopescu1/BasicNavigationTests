package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://www.google.com/");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );

        for (String searchStr: searchStrs) {
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.clear();//setting up the 2 and 3rd loop
            searchInput.sendKeys(searchStr+ Keys.ENTER);

            WebElement url = driver.findElement(By.cssSelector(".iUh30.tjvcx"));
            String expectedUrl = url.getText();
            System.out.println("expectedUrl = " + expectedUrl);

            WebElement link = driver.findElement(By.cssSelector("div.r>a h3"));
            Thread.sleep(2000);
            link.click();

            if(expectedUrl.equals(driver.getCurrentUrl())){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("Expected = " + expectedUrl);
                System.out.println("Actual =  " + driver.getCurrentUrl());
            }
            driver.navigate().back();
        }
        driver.quit();
    }
}
