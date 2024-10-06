package tests.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import utilities.BaseTest;

import java.util.HashMap;

public class BasicTest extends BaseTest {
    @Test(dataProvider="getData")
    public void basicTest(HashMap<String,String> data){
        Assert.assertTrue(homePage.isTitleCorrect(data.get("title")));
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("title", "WIKIPEDIA");
        return new Object[][] { {data} };
    }
}
