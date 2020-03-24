package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackShortcut {
    public static void main(String[] args) throws InterruptedException {
        shortcutFunc();
    }
    /*
1. Open browser
2. Go to Vytrack login page
3. Login as a sales manager
4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link See full list
11. Click on link Vehicle Service Logs
12. Verify error message text is You do not have
permission to perform this action.
13. Verify Shortcut Actions List page is still open
     */
    private static void shortcutFunc() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        assert driver != null;
        driver.get("https://qa3.vytrack.com");
        WebElement login = driver.findElement(By.id("prependedInput"));
        login.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(2000);
        String expected = "Dashboard";
        String actual = driver.getTitle();

        StringUtility.verifyStartsWith(expected, actual);

        WebElement shortcutIcon = driver.findElement(By.cssSelector("a[title='Shortcuts']"));
        shortcutIcon.click();
        WebElement allLinks = driver.findElement(By.linkText("See full list"));
        allLinks.click();

        Thread.sleep(2000);
        WebElement opportunities = driver.findElement(By.linkText("Opportunities"));
        opportunities.click();

        Thread.sleep(3000);
        StringUtility.verifyStartsWith("Open Opportunities", driver.getTitle());

        shortcutIcon.click();
        allLinks.click();

        Thread.sleep(2000);
        WebElement vehicleServiceLogs = driver.findElement(By.linkText("Vehicle Services Logs"));
        vehicleServiceLogs.click();

        Thread.sleep(2000);
        WebElement errorMsg = driver.findElement(By.cssSelector(".message"));
        //System.out.println(errorMsg.getText());

        Thread.sleep(2000);
        StringUtility.verifyStartsWith("You do not have permission to perform this action.", errorMsg.getText());
        StringUtility.verifyStartsWith("Shortcut Actions List", driver.getTitle());
        driver.quit();
    }
    }