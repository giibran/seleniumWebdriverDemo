package org.example.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.base.TestBase;
import org.example.pages.HeaderPage;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with standard user ")
    @Test
    public void LoginStandardUser(){
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser("standardUserName", "password");
        InventoryPage inventoryPage = loginPage.afterLogin();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getInventoryUrl());
        Assert.assertEquals(headerPage.validateLoggedInUser(), true);
        takeScreenShot("login with user");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Login with blocked user")
    @Test
    public void LoginLockedUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser("lockeddUserName", "password");
        Assert.assertEquals(loginPage.returnErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
        takeScreenShot("locked user");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Login with incorrect user and password")
    @Test
    public void LoginWrongUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser("invaludUserName", "password");
        Assert.assertEquals(loginPage.returnErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
        takeScreenShot("invalid credentials");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Logout after logged in user")
    @Test
    public void LogoutUser(){
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.OpenLoginPage();
        loginPage.loginWithUser("standardUserName", "password");
        headerPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginUrl());
        takeScreenShot("invalid credentials");
    }

}
