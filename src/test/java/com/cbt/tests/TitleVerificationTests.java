package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
public class TitleVerificationTests {
    public static void main(String[] args) throws InterruptedException {
   List<String> urls = Arrays.asList("http://practice.cybertekschool.com",
           "http://practice.cybertekschool.com/dropdown",
           "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get(urls.get(0));
        Thread.sleep(2000);
        String titleZero = driver.getTitle();
        driver.get(urls.get(1));
        Thread.sleep(2000);
        String titleOne = driver.getTitle();
        driver.get(urls.get(2));
        Thread.sleep(2000);
        String titleTwo = driver.getTitle();

       if(titleZero.equalsIgnoreCase(titleOne) &&
               titleOne.equalsIgnoreCase(titleTwo) &&
               titleTwo.equalsIgnoreCase(titleZero)) {
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
       }

        String start = "http://practice.cybertekschool.com";
        String url1 = driver.getCurrentUrl();
        String url2 = driver.getCurrentUrl();
        String url3 = driver.getCurrentUrl();

        if(url1.startsWith(start) && url2.startsWith(start) && url3.startsWith(start)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();


    }
}
