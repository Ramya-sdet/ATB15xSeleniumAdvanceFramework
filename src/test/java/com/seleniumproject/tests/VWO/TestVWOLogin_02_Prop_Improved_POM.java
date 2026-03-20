package com.seleniumproject.tests.VWO;

import com.seleniumproject.baseTest.CommonToAllTest;
import com.seleniumproject.driver.DriverManager;
import com.seleniumproject.pages.pageObjectModel.VWO.improved_POM.LoginPage;
import com.seleniumproject.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = (Logger) LogManager.getLogger(TestVWOLogin_02_Prop_Improved_POM.class);

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        logger.info("Browser is started....");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        logger.info("Verifying the Invalid credentials....");
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        logger.info("Final Assert Verifications....");
        // System.out.println(error_msg); No now!!
        logger.info(error_msg.toString());

       // logger.error("Failed to verify");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
