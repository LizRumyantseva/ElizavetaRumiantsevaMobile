package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativeMainPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement emailOrUserName;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement password;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement regBtn;

    public NativeMainPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }


}
