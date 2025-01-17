package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class PageBase {

    // TODO: define Webdriver
    WebDriver driver;
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    // TODO: hover method
    public static void hoverWebElement(WebDriver driver, WebElement element) {
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(element).perform();
    }
}
