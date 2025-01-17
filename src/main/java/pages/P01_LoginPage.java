package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage extends PageBase {

    // TODO: constructor to initialize Webdriver
    public P01_LoginPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using by
    private final By USERNAME_TEXT = By.id("user-name");
    private final By PASSWORD_TEXT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");

    // TODO: pubic action methods
    public P01_LoginPage enterUserName(String userName) {
        this.driver.findElement(this.USERNAME_TEXT).sendKeys(userName);
        return this;
    }
    public P01_LoginPage enterPassword(String password) {
        this.driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }
    public P01_LoginPage clickLoginButton() {
        this.driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }
}
