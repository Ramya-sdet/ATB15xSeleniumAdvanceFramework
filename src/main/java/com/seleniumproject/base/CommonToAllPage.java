package com.seleniumproject.base;

import com.seleniumproject.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.seleniumproject.driver.DriverManager.getDriver;

public class CommonToAllPage {

    //  Common to All Pages
    public void openVWOUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by) {
        return by.getText();
    }
}