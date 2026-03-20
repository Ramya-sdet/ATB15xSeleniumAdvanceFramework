package com.seleniumproject.pages.pageObjectModel.normal_POM.VWO;

import com.seleniumproject.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Page Class

    // Page locator
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    private By FreeTrial = By.xpath("//span[text()='Start a FREE TRIAL']");

    //private By rememberMeCheckBox = By.xpath("//div[@data-qa="lujafasagu"]']");


    // Page Actions
    public String loginToVWOInvalidCreds(String usr, String pwd) {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.checkVisibility(driver, error_message);
        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;

    }

    public void loginToVWOValidCreds(String usr, String pwd) {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
    }

    public void StartFreeTrial() {

        WaitHelpers.checkVisibility(driver, FreeTrial);
        driver.findElement(FreeTrial).click();
    }

}
