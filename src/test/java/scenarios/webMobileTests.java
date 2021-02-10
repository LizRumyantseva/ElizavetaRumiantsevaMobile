package scenarios;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.GoogleSearchPageObject;
import setup.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    private final String configPath = "src/test/resources/tests.properties";

    @Test(groups = {"web"}, description = "Make sure that we've made search on Google search page")
    public void simpleWebTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {
        Properties properties = getProperties();
        String searchString = properties.getProperty("searchString");

        GoogleSearchPageObject googleSearchPageObject = new GoogleSearchPageObject(getDriver());
        getDriver().get(googleSearchPageObject.getUrl());

        googleSearchPageObject.getQueryField().sendKeys(searchString);
        googleSearchPageObject.getQueryField().sendKeys(Keys.ENTER);

        assertTrue(!googleSearchPageObject.getResultList().isEmpty());

    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(configPath)));
        return  properties;
    }

}
