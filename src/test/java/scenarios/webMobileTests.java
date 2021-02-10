package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've made search on Google search page")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {

        String searchString = properties.getProperty("searchString");

        getDriver().get("https://www.google.com/"); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 20).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWeInGoogleSearchPageObject("queryField").sendKeys(searchString);
        getPo().getWeInGoogleSearchPageObject("queryField").sendKeys(Keys.ENTER);
        assertTrue(!getPo().getListWeInGoogleSearchPageObject("resultList").isEmpty());

    }

}
