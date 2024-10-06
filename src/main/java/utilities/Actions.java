package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Actions {
    WebDriver driver;

    public Actions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
