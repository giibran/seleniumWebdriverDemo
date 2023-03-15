package org.example.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.base.TestBase;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.PropertyReader;
import org.example.utils.WaitForHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Description("test Login ")
    @Test
    public void Login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser();
        InventoryPage inventoryPage = loginPage.afterLogin();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getInventoryUrl());
        takeScreenShot("login with user");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("verify logged in user")
    @Test
    public void verifyLoggedInUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser();
        InventoryPage inventoryPage = loginPage.afterLogin();
        Assert.assertEquals(inventoryPage.validateLoggedInUser(), true);
        takeScreenShot("verify logged user");
    }
}
