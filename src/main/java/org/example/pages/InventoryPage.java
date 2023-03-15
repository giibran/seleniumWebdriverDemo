package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InventoryPage extends BasePage {
    WebDriver driver;

    public InventoryPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    String url = "https://www.saucedemo.com/inventory.html";
    By titleContainer = By.className("title");
    By cartIcon = By.id("shopping_cart_container");

    public String getInventoryUrl(){
        return this.url;
    }
    public boolean validateLoggedInUser(){
        waitForElementToAppear(cartIcon);
        return driver.findElement(cartIcon).isDisplayed();
    }
}
