package setup;

import org.openqa.selenium.WebElement;
import pageObjects.GoogleSearchPageObject;

public interface IPageObject {

    WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeMainPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeBudgetActivityPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    WebElement getNativeRegistrationPageObject(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}