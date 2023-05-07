package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
         *  SELENIUM WEBDRIVER ARCHITECTURE
         *  1.The App(Client) with code written using Java language and Selenium library is converted to JSON format and
         *  transfer over HTTP protocol to the Browser Driver(Server).
         *  2.The Browser Driver interpret the JSON and send the commands to its respective Browser.
         *  3.The Browser Driver receives the responses back from the Browser and sends responses in JSON to the Client.
         * */

        // Path in the computer to the Chromedriver.exe
        String path = "/Users/nayibarayagarreta/Study/Selenium/SeleniumStudy/drivers/chromedriver";
        String driverInUse = "webdriver.chrome.driver";
        /*
         * Selenium to works properly needs to the have defined the path from the BrowserDriver in the property driver.
         * */
        System.setProperty(driverInUse,path);

        /*
         * ChromeDriver has the implementation of the methods inherit from WebDriver(Interface).
         * ChromeDriver has the methods to handle and interact with the Browser.
         * We use WebDriver as class of driver variable to forced to use only the implemented methods in ChromeDriver from
         * WebDriver. This to improve compatibility when testing in browsers.
         * */
        WebDriver driver = new ChromeDriver();

        // Driver says Chrome to Open the URL
        driver.get("https://google.com");
    }
}