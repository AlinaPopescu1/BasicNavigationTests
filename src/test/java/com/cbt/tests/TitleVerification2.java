package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList
                ("https://luluandgeorgia.com",
                        "https://wayfair.com",
                        "https://www.westelm.com",
                        "https://walmart.com");

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;

        driver.get(urls.get(0));
        String urlLulu = driver.getCurrentUrl();
        String urlLuluTitle = driver.getTitle();
        driver.get(urls.get(1));
        String urlWF = driver.getCurrentUrl();
        String WFTitle = driver.getTitle();
        driver.get(urls.get(2));
        String urlWEST = driver.getCurrentUrl();
        String WESTTitle = driver.getTitle();
        driver.get(urls.get(3));
        String urlWalmart = driver.getCurrentUrl();
        String WalmartTitle = driver.getTitle();

        String convertedTitle = urlLuluTitle.
                replace(" ", "").
                replace("L", "l").
                replace("G", "g");

        System.out.println(convertedTitle);
        //verify 1st website
        if (urlLulu.contains(convertedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        //Verify 2nd website
        if (urlWF.contains(WFTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //Verify the 3rd website
        if(urlWEST.contains(WESTTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //Verify 4th website
        if (urlWalmart.contains(WalmartTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();
    }
    }
