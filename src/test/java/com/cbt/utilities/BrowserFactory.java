package com.cbt.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        String opSysName = System.getProperty("os.name");
        WebDriver webDriver = null;
        if (browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.contains("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (browser.contains(("Safari"))) {
            System.setProperty("webdriver.safari.driver", "C:/safaridriver.exe");
            webDriver = new SafariDriver();
        } else if (browser.contains("Edge")
                && opSysName.contains("Mac")
                ||
                browser.contains("Explorer")
                        && opSysName.contains("Mac")) {
            return null;
        }
         return webDriver;
    }
}


