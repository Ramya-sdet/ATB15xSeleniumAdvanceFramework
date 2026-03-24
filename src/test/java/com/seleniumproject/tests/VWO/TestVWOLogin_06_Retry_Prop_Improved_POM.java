package com.seleniumproject.tests.VWO;

import com.seleniumproject.baseTest.CommonToAllTest;
import com.seleniumproject.listeners.RetryAnalyzer;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.seleniumproject.driver.DriverManager.getDriver;

@Test(retryAnalyzer = RetryAnalyzer.class )
public class TestVWOLogin_06_Retry_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_06_Retry_Prop_Improved_POM.class);


    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(false);
    }

    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }

}
