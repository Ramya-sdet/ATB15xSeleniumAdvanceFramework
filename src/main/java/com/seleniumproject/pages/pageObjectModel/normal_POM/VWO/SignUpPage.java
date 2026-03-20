package com.seleniumproject.pages.pageObjectModel.normal_POM.VWO;

import com.seleniumproject.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SignUpPage {
    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    private By FirstName = By.xpath("//input[@data-qa='page-su-v1-fname']");
    private By LastName = By.xpath("//input[@data-qa='page-su-v1-lname']");
    private By PhoneNumber = By.xpath("//input[@data-qa='page-su-v1-pnumber']");
    private By CreateAccount = By.xpath("//button[text()='Create Account']");
    private By SkipAndContinuetoApp=By.xpath("//button[@data-step=\"free-trial-thankyou\"]");
    //actions
    public void SignUp(String FName, String LName, String PNumber) {
        WaitHelpers.checkVisibility(driver, FirstName);
        driver.findElement(FirstName).sendKeys(FName);
        driver.findElement(LastName).sendKeys(LName);
        driver.findElement(PhoneNumber).sendKeys(PNumber);
        WaitHelpers.checkVisibility(driver,CreateAccount);
        driver.findElement(CreateAccount).click();
        WaitHelpers.checkVisibility(driver,SkipAndContinuetoApp);
        driver.findElement(SkipAndContinuetoApp).click();
    }

}
