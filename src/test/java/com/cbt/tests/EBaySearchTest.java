package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class EBaySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;

        driver.get("https://ebay.com");
        WebElement search  = driver.findElement(By.id("gh-ac"));
        search.sendKeys("wooden spoon"+ Keys.ENTER);
        Thread.sleep(2000);
        WebElement countElements = driver.findElement(By.cssSelector("h1>span"));
        String count = countElements.getText();
        int totalRes = Integer.parseInt(count.replace(",",""));
        System.out.println("totalRes = " + totalRes);
        WebElement all = driver.findElement(By.linkText("All"));
        all.click();

        //re-initialize the element that is throwing StaleElementException
        //because we clicked All one more time we need to reinitialize the page
        //it is different page basically
        //in order to check both results we need to create another webElement with that data
        countElements=driver.findElement(By.cssSelector("h1>span"));
        count=countElements.getText();
        System.out.println("count = " + count);

        int countTwo = Integer.parseInt(count.replace(",",""));
        System.out.println("countTwo = " + countTwo);

        if(totalRes<countTwo) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("totalRes = " + totalRes);
            System.out.println("countTwo = " + countTwo);

            driver.navigate().back();
            search = driver.findElement(By.id("gh-ac"));
            String woodenSpoon = search.getAttribute("value");
            System.out.println("woodenSpoon = " + woodenSpoon);

            //System.out.println(StringUtility.verifyEquals("wooden spoon", woodenSpoon));

            if(woodenSpoon.isEmpty()){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("Expected a blank value");
                System.out.println("Actual "+woodenSpoon);
            }
            driver.quit();
        }
    }
}

