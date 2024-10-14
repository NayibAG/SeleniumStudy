package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class SetUp {
    /*
     *  SELENIUM WEBDRIVER ARCHITECTURE
     *  1.The App(Client) with code written using Java language and Selenium library is converted to JSON format and
     *  transfer over HTTP protocol to the Browser Driver(Server).
     *  2.The Browser Driver interpret the JSON and send the commands to its respective Browser.
     *  3.The Browser Driver receives the responses back from the Browser and sends responses in JSON to the Client.
     */

    private static WebDriver driver;
    private static Properties properties;
    private static final String DOWNLOADPATH = System.getProperty("user.dir")+"\\src\\test\\java\\data\\";


    public static WebDriver getDriver() {
        return driver;
    }
    public static Properties getProperties() {
        return properties;
    }

    public static void Setup(){
        loadGlobalVariables();
        startDriverRemote();
    }

    private static void loadGlobalVariables() {
//        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties";
        String filePath = System.getProperty("user.dir")+"/src/main/resources/data.properties";
        properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);

        }catch (IOException ex){

        }
    }

    public static void startDriverRemote() {
        String browserName = System.getenv("BROWSER_NAME")!=null ? System.getenv("BROWSER_NAME") : properties.getProperty("BROWSER_NAME");
        String url = System.getenv("PAGE_URL")!=null ? System.getenv("PAGE_URL") : properties.getProperty("PAGE_URL");
        String hubHost = System.getenv("HUB_HOST") !=null ? System.getenv("HUB_HOST") : properties.getProperty("HUB_HOST");
        String hubPort = System.getenv("HUB_PORT")!=null ? System.getenv("HUB_PORT") : properties.getProperty("HUB_PORT");
        String hub = "http://"+hubHost+":"+hubPort+"/";

        DesiredCapabilities caps = new DesiredCapabilities();
        try{
            switch(browserName.toLowerCase()) {
                case "chrome":{
                    caps.setCapability(CapabilityType.BROWSER_NAME,"chrome");
                    driver = new RemoteWebDriver(new URL(hub),caps);
                    break;
                }
                case "firefox":{
                    caps.setCapability(CapabilityType.BROWSER_NAME,"firefox");
                    driver = new RemoteWebDriver(new URL(hub),caps);
                    break;
                }
            }
        }catch(MalformedURLException exception){

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Increase the amount of time the driver waits for responses or renders to load.
        driver.manage().window().maximize();
        driver.get(url);
    }

    /*
     * ChromeDriver has the implementation of the methods inherit from WebDriver(Interface).
     * ChromeDriver has the methods to handle and interact with the Browser.
     * We use WebDriver as class of driver variable to forced to use only the implemented methods in ChromeDriver from
     * WebDriver. This to improve compatibility when testing in browsers.
     */
    public static void startDriver() {
        String browserName = System.getProperty("browserName")!=null ? System.getProperty("browserName") : properties.getProperty("browserName");
        String url = System.getProperty("url")!=null ? System.getProperty("url") : properties.getProperty("url");

        switch(browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(setupChrome());
                break;
            case "firefox":
                driver = new FirefoxDriver(setupFireFox());
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Increase the amount of time the driver waits for responses or renders to load.
        driver.manage().window().maximize();
        driver.get(url);
    }

    private static ChromeOptions setupChrome(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOADPATH);
//        prefs.put("download.prompt_for_download", false);
//        prefs.put("download.directory_upgrade", true);
//        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static FirefoxOptions setupFireFox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("profile.default_content_settings.popups", 0);
        options.addPreference("browser.download.folderList", 2); // 0 = desktop, 1 = downloads, 2 = custom path
        options.addPreference("browser.download.dir", DOWNLOADPATH);
        return options;
    }
}
