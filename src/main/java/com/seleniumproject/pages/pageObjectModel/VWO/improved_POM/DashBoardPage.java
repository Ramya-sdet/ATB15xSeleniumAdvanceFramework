package com.seleniumproject.pages.pageObjectModel.VWO.improved_POM;

import com.seleniumproject.base.CommonToAllPage;
import com.seleniumproject.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage  extends CommonToAllPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
