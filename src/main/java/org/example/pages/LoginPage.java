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

    String url = "https://www.saucedemo.com/";
    By username = By.id("user-name");
    By password = By.id("password");
    By signButton = By.id("login-button");
    By errorMessageContainer = By.xpath("//*[@data-test='error']");

    public String getLoginUrl(){
        return this.url;
    }

    public void OpenLoginPage(){
        driver.get(PropertyReader.readItem("baseUrl"));
    }

    public void loginWithUser(String userText, String password){
        writeText(username, PropertyReader.readItem(userText));
        writeText(this.password, PropertyReader.readItem(password));
        click(signButton);
    }

    public String returnErrorMessage(){
        waitForElementToAppear(errorMessageContainer);
        String errorMessage = driver.findElement(errorMessageContainer).getText();
        return errorMessage;
    }

    public InventoryPage afterLogin(){
        return new InventoryPage(driver);
    }
}
