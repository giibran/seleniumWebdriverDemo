package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    WebDriver driver;

    public HeaderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By headerContainer = By.className("primary_header");
    By burgerMenuButton = By.id("react-burger-menu-btn");
    By appLogo = By.className("app_logo");
    By cartIcon = By.id("shopping_cart_container");
    By logOutMenuItem = By.id("logout_sidebar_link");

    public boolean validateLoggedInUser(){
        waitForElementToAppear(cartIcon);
        return driver.findElement(cartIcon).isDisplayed();
    }

    public void logout(){
        click(burgerMenuButton);
        click(logOutMenuItem);
    }
}
