package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPageObject {
//    private String url = "https://www.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement queryField;

    @FindBy(xpath = "//*[@id='rso']/div")
    private List<WebElement> resultList;

    public GoogleSearchPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

}