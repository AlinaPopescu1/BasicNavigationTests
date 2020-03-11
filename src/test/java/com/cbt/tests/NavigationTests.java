package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTests {
    public void testChrome() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        assert driver != null;
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String titleGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals("Google", titleGoogle));
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals
                ("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", titleEtsy));
        driver.close();
    }
    public void testSafari() throws Exception {
        WebDriver driver = BrowserFactory.getDriver("safari");
        assert driver != null;
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String titleGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals("Google", titleGoogle));
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals
                ("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", titleEtsy));
        driver.close();
    }
    public void testFirefox() throws Exception {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        assert driver != null;
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String titleGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals("Google", titleGoogle));
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println(StringUtility.verifyEquals
                ("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", titleEtsy));
        driver.close();
    }
    public static void main(String[] args) throws Exception {
    NavigationTests nav = new NavigationTests();
    nav.testChrome();
    nav.testFirefox();
    nav.testSafari();

    }
}