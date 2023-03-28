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

    public String getInventoryUrl(){
        return this.url;
    }

}
