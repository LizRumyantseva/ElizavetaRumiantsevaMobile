package hw2.scenarios;

import org.testng.annotations.Test;
import hw2.setup.BaseTest;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Register a new account and then sign in")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {

        String email = properties.getProperty("email");
        String name = properties.getProperty("username");
        String password = properties.getProperty("password");

        getPo().getWelement("regBtn").click();
        getPo().getWelement("regEmail").sendKeys(email);
        getPo().getWelement("regUserName").sendKeys(name);
        getPo().getWelement("regPassword").sendKeys(password);
        getPo().getWelement("regConfirmPassword").sendKeys(password);
        getPo().getWelement("regNewAccountBtn").click();
        getPo().getWelement("emailOrUserName").sendKeys(email);
        getPo().getWelement("password").sendKeys(password);
        getPo().getWelement("signInBtn").click();
        assertTrue(getPo().getWelement("addExpenseBtn").isDisplayed());

        System.out.println("Simplest Android native test done");
    }

}
