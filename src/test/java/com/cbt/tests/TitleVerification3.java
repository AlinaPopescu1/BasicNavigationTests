package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList
                ("https://luluandgeorgia.com",
                        "https://wayfair.com",
                        "https://www.westelm.com",
                        "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;

        //open a new browser
        driver.get(urls.get(0));
        String urlLulu = driver.getCurrentUrl();
        String urlLuluTitle = driver.getTitle();
        String convertedTitle = urlLuluTitle.
                replace(" ", "").
                replace("L", "l").
                replace("G", "g");
        //verify 1st website
        if (urlLulu.contains(convertedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            //close the browser
            driver.close();

        //verify 2nd website
            WebDriver driver2 = BrowserFactory.getDriver("Chrome");
            assert driver2 != null;
            driver2.get(urls.get(1));
            String urlWF = driver2.getCurrentUrl();
            String WFTitle = driver2.getTitle();
            if (urlWF.contains(WFTitle)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
            driver2.close();

            //verify 3rd website
            WebDriver driver3 = BrowserFactory.getDriver("Chrome");
            assert driver3 != null;
            driver3.get(urls.get(2));
            String urlWEST = driver3.getCurrentUrl();
            String WESTTitle = driver3.getTitle();
            if(urlWEST.contains(WESTTitle)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
            driver3.close();

            WebDriver driver4 = BrowserFactory.getDriver("Chrome");
            assert driver4 != null;
            //verify 4th website
            driver4.get(urls.get(3));
            String urlWalmart = driver4.getCurrentUrl();
            String WalmartTitle = driver4.getTitle();
            if (urlWalmart.contains(WalmartTitle)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }
            driver4.close();
        }
    }
}
