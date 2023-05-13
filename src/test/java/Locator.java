import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {
    WebDriver driver;

    public Locator(WebDriver driver) {
        this.driver = driver;
    }

    /*
     * The Locator are the way to identify an HTML element on a web page.
     * Locator Types: -ID -XPath - CSS Selector - Name - Class Name - Tag Name - Link Text - Partial Link Text
     * */

    public void exampleID(){
        /*
        * <textarea class="gLFyf" jsaction="paste:puy29d;" id="APjFqb" maxlength="2048" name="q" rows="1"
        * aria-activedescendant="" aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
        * aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus=""
        * role="combobox" spellcheck="false" title="Buscar" type="search" value="" aria-label="Buscar"
        * data-ved="0ahUKEwjrpu6R6vL-AhUtK0QIHV4VAXMQ39UDCAQ"></textarea>
        * */

        driver.findElement(By.id("APjFqb")).sendKeys("Locator by ID");
    }

    public void exampleName(){

    }

    public void exampleClassName(){

    }


}
