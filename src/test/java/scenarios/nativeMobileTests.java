package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {

    private final String configPath = "src/test/resources/tests.properties";

    @Test(groups = {"native"}, description = "Register a new account and then sign in")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {

        Properties properties = getProperties();
        String email = properties.getProperty("email");
        String name = properties.getProperty("username");
        String password = properties.getProperty("password");

        getPo().getNativeMainPageObject("regBtn").click();
        getPo().getNativeRegistrationPageObject("regEmail").sendKeys(email);
        getPo().getNativeRegistrationPageObject("regUserName").sendKeys(name);
        getPo().getNativeRegistrationPageObject("regPassword").sendKeys(password);
        getPo().getNativeRegistrationPageObject("regConfirmPassword").sendKeys(password);
        getPo().getNativeRegistrationPageObject("regNewAccountBtn").click();
        getPo().getNativeMainPageObject("emailOrUserName").sendKeys(email);
        getPo().getNativeMainPageObject("password").sendKeys(password);
        getPo().getNativeMainPageObject("signInBtn").click();
        assertTrue(getPo().getNativeBudgetActivityPageObject("addExpenseBtn").isDisplayed());
        //assertEquals(getPo().getNativeBudgetActivityPageObject("actionBarTitle").getText(), "BudgetActivity");
        System.out.println("Simplest Android native test done");
    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(configPath)));
        return properties;
    }

}
