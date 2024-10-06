package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Actions;

public class HomePage extends Actions {
    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Page Objects */
    @FindBy(xpath = "//div[@class='central-textlogo']//span")
    private WebElement title;

    /* Action Methods */
    public Boolean isTitleCorrect(String _title){
        return title.getText().toUpperCase().equals(_title);
    }

}
