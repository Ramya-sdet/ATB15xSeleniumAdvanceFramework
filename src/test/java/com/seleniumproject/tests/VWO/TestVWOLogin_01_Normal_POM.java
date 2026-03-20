package com.seleniumproject.tests.VWO;

import com.seleniumproject.pages.pageObjectModel.normal_POM.VWO.DashboardPage;
import com.seleniumproject.pages.pageObjectModel.normal_POM.VWO.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_01_Normal_POM {
    @Owner("PRAMOD")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCreds("admin@gmail.com","1234");
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();



    }

    @Description("Verify that with valid email, pass,logins and open Dashboard page.")
    @Test
    public void test_positive_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidCreds("anu52@itdbe.com","Test@123");
        // Assertions - 3 - V
        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        Assert.assertEquals(userNameLoggedIn,"Ramya");
        driver.quit();



    }



}
