import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        SetUp setUp = new SetUp();
        WebDriver driver = setUp.getDriver();

        //Locator Section
        Locator locator = new Locator(driver);
        //locator.exampleID();
        //locator.exampleName();
        //locator.exampleClassName();
        //locator.exampleCCSSelector();
        //locator.exampleLinkText();
        //locator.exampleXPath();













        //driver.close();


    }
}
