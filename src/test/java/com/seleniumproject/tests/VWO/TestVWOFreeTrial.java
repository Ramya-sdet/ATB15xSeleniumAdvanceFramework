package com.seleniumproject.tests.VWO;

import com.seleniumproject.pages.pageObjectModel.normal_POM.VWO.FreeTrialPage;
import com.seleniumproject.pages.pageObjectModel.normal_POM.VWO.LoginPage;
import com.seleniumproject.pages.pageObjectModel.normal_POM.VWO.SignUpPage;
import com.seleniumproject.utils.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestVWOFreeTrial {

    @Description("Check if free trial works.")
    @Test
    public void Start_Free_Trial (){
        // Driver Manager Code
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        //Save the ID of the original login tab
        String originalTab = driver.getWindowHandle();
        //login page
        LoginPage FreeTrial = new LoginPage(driver);

        FreeTrial.StartFreeTrial();
        //THE SWITCH: Tell the driver to find the new tab and switch to it
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // Stop looking once we find and switch to the new tab
            }
        }
        //free trial page
        FreeTrialPage CreateFreeTrial = new FreeTrialPage(driver);
        CreateFreeTrial.CreateFreeTrialAccount("anu22@itdbe.com");

        WaitHelpers.waitJVM(2000);
        WebElement cookiepopup =driver.findElement(By.xpath("//button[@aria-label=\"Close\"]"));
        cookiepopup.click();
        WaitHelpers.waitJVM(2000);

        //Sign up page
        SignUpPage CreateAccount = new SignUpPage(driver);
        CreateAccount.SignUp("Anu", "Ram","7846542341");


    }
}
