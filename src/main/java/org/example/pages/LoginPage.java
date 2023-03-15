package org.example.pages;

import org.example.base.BasePage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By signButton = By.id("login-button");

    public void OpenLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void loginWithUser(){
        writeText(username, PropertyReader.readItem("username"));
        writeText(password, PropertyReader.readItem("password"));
        click(signButton);
    }

    public InventoryPage afterLogin(){
        return new InventoryPage(driver);
    }
}
