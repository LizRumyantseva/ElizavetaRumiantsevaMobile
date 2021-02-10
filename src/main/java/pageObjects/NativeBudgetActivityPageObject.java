package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class NativeBudgetActivityPageObject {
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/action_bar")
    private WebElement actionBarTitle;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    public WebElement addExpenseBtn;

    public NativeBudgetActivityPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
