
package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    private static final String SEARCHFIELD = "gh-ac";
    private static final String WWWW_SITE = "https://www.ebay.com";

    public static void main(String[] args) {
        EBayTestingApp testApp = new EBayTestingApp();
        testApp.testWith(WebDriverConfig.CHROME);
        testApp.testWith(WebDriverConfig.FIREFOX);
    }

    private void testWith(String browser) {
        WebDriver driver = WebDriverConfig.getDriver(browser);
        try {
            assert driver != null;
            driver.get(WWWW_SITE);
        } catch (Exception e) {
            System.out.println("wrong site www");
        }
        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("Laptop for dummies");
        searchField.submit();
    }
}