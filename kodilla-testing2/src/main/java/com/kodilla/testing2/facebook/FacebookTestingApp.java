package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String FB_HOME = "https://www.facebook.com/";
    private static final String FIRSTNAME = "Aaaaaaa";
    private static final String LASTNAME = "Bbbbbbbb";
    private static final String YEAR = "1999";
    private static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    private static final String XPATH_SELECT_MONTH= "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    private static final String XPATH_SELECT_YEAR= "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";
    private static final String XPATH_FB_INPUT_FISTNAME = "//*[@id=\"u_0_l\"]";
    private static final String XPATH_FB_INPUT_LASTNAME = "//*[@id=\"u_0_n\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        if(driver != null) {
            driver.get(FB_HOME);

            webElementsInputer(driver, XPATH_FB_INPUT_FISTNAME,FIRSTNAME );
            webElementsInputer(driver ,XPATH_FB_INPUT_LASTNAME , LASTNAME);

            webSelectorInputer(driver ,XPATH_SELECT_DAY , "1");
            webSelectorInputer(driver ,XPATH_SELECT_MONTH , "2");
            webSelectorInputer(driver ,XPATH_SELECT_YEAR , YEAR);
        } else
            System.out.println("Sth went wrong...where is driver?!");
    }

    private static void webElementsInputer(WebDriver driver, String xPathName, String keyToSend) {
        WebElement nameField = driver.findElement(By.xpath(xPathName));
        nameField.sendKeys(keyToSend);

    }
    private static void webSelectorInputer(WebDriver driver, String xPathName, String keyToSend) {
        while (!driver.findElement(By.xpath(xPathName)).isDisplayed()) ;
        WebElement selectPath = driver.findElement(By.xpath(xPathName));
        Select selectBoard = new Select(selectPath);
        selectBoard.selectByValue(keyToSend);
    }
}


