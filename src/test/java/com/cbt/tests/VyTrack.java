package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack {
    public static void main(String[] args) throws InterruptedException {
        titleTests();
    }
/*
1. Open browser
2. Go to Vytrack login page
3. Login as any user
4. Click on your name on top right
5. Click on My Configuration
6. Verify that page title starts with the same name on top
right
 */
    private static void titleTests() throws InterruptedException {
    WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement login = driver.findElement(By.id("prependedInput"));
        login.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();
        WebElement userClick = driver.findElement(By.cssSelector("a[class='dropdown-toggle']    "));
        Thread.sleep(3000);
        userClick.click();
        WebElement config = driver.findElement(By.cssSelector("ul.dropdown-menu a[href='/config/user/profile']"));
        config.click();

        Thread.sleep(1000);
        String expected = userClick.getText();
        String actual = driver.getTitle();

        if(actual.startsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
        driver.close();
    }
}
