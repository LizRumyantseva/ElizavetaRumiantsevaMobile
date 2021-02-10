package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import setup.IPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class PageObject implements IPageObject {

    private Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    private NativeMainPageObject nativeMainPageObject;
    private NativeBudgetActivityPageObject nativeBudgetActivityPageObject;
    private NativeRegistrationPageObject nativeRegistrationPageObject;
    private GoogleSearchPageObject googleSearchPageObject;

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                googleSearchPageObject = new GoogleSearchPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new WebPageObject(appiumDriver);
                nativeMainPageObject = new NativeMainPageObject(appiumDriver);
                nativeBudgetActivityPageObject = new NativeBudgetActivityPageObject(appiumDriver);
                nativeRegistrationPageObject = new NativeRegistrationPageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }


    @Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }

    @Override
    public WebElement getNativeMainPageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = nativeMainPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(nativeMainPageObject);
    }

    @Override
    public WebElement getNativeRegistrationPageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = nativeRegistrationPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(nativeRegistrationPageObject);
    }

    @Override
    public WebElement getNativeBudgetActivityPageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = nativeBudgetActivityPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(nativeBudgetActivityPageObject);
    }

    @Override
    public WebElement getWeInGoogleSearchPageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = googleSearchPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(googleSearchPageObject);
    }

    @Override
    public List<WebElement> getListWeInGoogleSearchPageObject(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = googleSearchPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(googleSearchPageObject);
    }

}
