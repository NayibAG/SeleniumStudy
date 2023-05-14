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
     * Locator Types: -ID -XPath(Generic) - CSS Selector(Generic) - Name - Class Name - Tag Name - Link Text - Partial Link Text
     * */

    public void exampleID(){
        driver.get("https://google.com");
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
        driver.get("https://google.com");
        /*
         * <textarea class="gLFyf" jsaction="paste:puy29d;" id="APjFqb" maxlength="2048" name="q" rows="1"
         * aria-activedescendant="" aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
         * aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus=""
         * role="combobox" spellcheck="false" title="Buscar" type="search" value="" aria-label="Buscar"
         * data-ved="0ahUKEwjrpu6R6vL-AhUtK0QIHV4VAXMQ39UDCAQ"></textarea>
         * */

        driver.findElement(By.name("q")).sendKeys("Locator by Name");
    }

    public void exampleClassName(){
        driver.get("https://google.com");
        /*
         * <textarea class="gLFyf" jsaction="paste:puy29d;" id="APjFqb" maxlength="2048" name="q" rows="1"
         * aria-activedescendant="" aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
         * aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus=""
         * role="combobox" spellcheck="false" title="Buscar" type="search" value="" aria-label="Buscar"
         * data-ved="0ahUKEwjrpu6R6vL-AhUtK0QIHV4VAXMQ39UDCAQ"></textarea>
         * */

        driver.findElement(By.className("gLFyf")).sendKeys("Locator by ClassName");
    }
    public void exampleCCSSelector(){
        /*
         * <textarea class="gLFyf" jsaction="paste:puy29d;" id="APjFqb" maxlength="2048" name="q" rows="1"
         * aria-activedescendant="" aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
         * aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus=""
         * role="combobox" spellcheck="false" title="Buscar" type="search" value="" aria-label="Buscar"
         * data-ved="0ahUKEwjrpu6R6vL-AhUtK0QIHV4VAXMQ39UDCAQ"></textarea>
         * */

        // Method 1 ClassName -> tagname.classname
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("textarea.gLFyf")).sendKeys("Locator by CSS Selector Method 1");
        // Method 2 ID -> tagname#id
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys("Locator by CSS Selector Method 2");
        // Method 3 Other -> tagname[attribute='value']
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Locator by CSS Selector Method 3");

        //Para verificar que sea unico meter en el inspec console del browser $("textarea.gLFyf")
        // tagname[attribute='value']:nth-child(index) Use in case you need to point one with multiple elements and have any other way

        //Method 4 parentElement childTagname Tambien se puede llegar a los elementos atraves de los padres dejando un espacio entre ellos.
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("div[class='a4bIc'] textarea")).sendKeys("Locator by CSS Selector Method 4");

        // Method 5 ClassName -> .classname
        driver.get("https://google.com");
        driver.findElement(By.cssSelector(".gLFyf")).sendKeys("Locator by CSS Selector Method 5");

    }

    public void exampleXPath(){
        /*
         * <textarea class="gLFyf" jsaction="paste:puy29d;" id="APjFqb" maxlength="2048" name="q" rows="1"
         * aria-activedescendant="" aria-autocomplete="both" aria-controls="Alh6id" aria-expanded="false"
         * aria-haspopup="both" aria-owns="Alh6id" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus=""
         * role="combobox" spellcheck="false" title="Buscar" type="search" value="" aria-label="Buscar"
         * data-ved="0ahUKEwjrpu6R6vL-AhUtK0QIHV4VAXMQ39UDCAQ"></textarea>
         * */
        // Systaxis //tagname[@attribute='value']
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Locator by XPath");

        // Para verificar que sea unico meter en el inspec console del browser $x("//textarea[@name='q']")
        // Use in case you need to point one with multiple elements and have any other way //tagname[@attribute='value'][index]

        //Systax //parentElement/childTagname Tambien se puede llegar a los elementos atraves de los padres.
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[@class='a4bIc']/textarea")).sendKeys("Locator by XPath");
    }

    public void exampleLinkText(){
        driver.get("https://google.com");
        /*
        * <a class="gb_t" aria-label="Busca Imágenes (abre una pestaña nueva)" data-pid="2"
        * href="https://www.google.co.cr/imghp?hl=es-419&amp;ogbl" target="_top">Imágenes</a>
        * */
        driver.findElement(By.linkText("Imágenes")).click();
    }



}
