package setup;

import org.openqa.selenium.WebElement;
import pageObjects.GoogleSearchPageObject;

import java.util.List;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeMainPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeBudgetActivityPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeRegistrationPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getWeInGoogleSearchPageObject (String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    List<WebElement> getListWeInGoogleSearchPageObject (String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}