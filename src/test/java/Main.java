import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        SetUp setUp = new SetUp();
        WebDriver driver = setUp.getDriver();
        driver.get("https://google.com");


    }
}
