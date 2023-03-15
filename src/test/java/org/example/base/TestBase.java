package org.example.base;

import io.qameta.allure.Allure;
import jdk.jpackage.internal.Log;
import org.example.utils.DriverManager;
import org.example.utils.PropertyReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class TestBase extends DriverManager {
    public WebDriver driver;
    PropertyReader pr = new PropertyReader();

    public TestBase(){
        this.driver = super.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        try{
            if (PropertyReader.readItem("browser").equals("firefox")){
                System.setProperty("webdriver.gecko.driver", "/Users/gibranarias/Downloads/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            else {
                try {
                    throw new Exception("browser driver is not supported.");
                }
                catch (Exception e)
                {
                    com.sdetblueprint.utils.Log.error("No compatible browser found.", e);
                }
            }

        }catch (Exception e){
            com.sdetblueprint.utils.Log.error("Browser Launch error.", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
