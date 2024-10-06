package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties properties;
    protected HomePage homePage;

    @BeforeMethod
    public void launchApp(){
        SetUp.Setup();
        properties = SetUp.getProperties();
        driver = SetUp.getDriver();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
