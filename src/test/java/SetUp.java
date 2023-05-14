import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SetUp {
    /*
     *  SELENIUM WEBDRIVER ARCHITECTURE
     *  1.The App(Client) with code written using Java language and Selenium library is converted to JSON format and
     *  transfer over HTTP protocol to the Browser Driver(Server).
     *  2.The Browser Driver interpret the JSON and send the commands to its respective Browser.
     *  3.The Browser Driver receives the responses back from the Browser and sends responses in JSON to the Client.
     * */

    // Path in the computer to find the Chromedriver.exe
    String pathMac = "/Users/nayibarayagarreta/Study/Selenium/SeleniumStudy/drivers/Mac/chromedriver";
    String pathWin = "/Users/nayib.araya/Documents/GitHub/SeleniumStudy/drivers/Windows/chromedriver.exe";
    String driverInUse = "webdriver.chrome.driver";
    WebDriver driver;

    public SetUp() {
        // Selenium to works properly needs to the have defined the path from the BrowserDriver in the property driver.
        System.setProperty(driverInUse,pathWin);

        /*
         * ChromeDriver has the implementation of the methods inherit from WebDriver(Interface).
         * ChromeDriver has the methods to handle and interact with the Browser.
         * We use WebDriver as class of driver variable to forced to use only the implemented methods in ChromeDriver from
         * WebDriver. This to improve compatibility when testing in browsers.
         * */
        this.driver = new ChromeDriver();

        // Increase the amount of time the driver waits for responses or renders to load.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
