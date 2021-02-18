package hw2.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import hw2.setup.IPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class PageObject implements IPageObject {

    private Object somePageObject; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePageObject = new GoogleSearchPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativeAppPageObject(appiumDriver);
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
    public List<WebElement> getListWelements(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(somePageObject);
    }

}
