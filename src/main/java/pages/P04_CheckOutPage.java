package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckOutPage extends PageBase{

    // TODO: constructor to initialize Webdriver
    public P04_CheckOutPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using by
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By POSTAL_CODE = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.xpath("(//input)[@value='CONTINUE']");

    // TODO: pubic action methods
    public P04_CheckOutPage enterFirstName(String firstName) {
        this.driver.findElement(this.FIRST_NAME).sendKeys(firstName);
        return this;
    }
    public P04_CheckOutPage enterLastName(String lastName) {
        this.driver.findElement(this.LAST_NAME).sendKeys(lastName);
        return this;
    }
    public P04_CheckOutPage enterPostalCode(String postalCode) {
        this.driver.findElement(this.POSTAL_CODE).sendKeys(postalCode);
        return this;
    }
    public P04_CheckOutPage clickContinueButton() {
        this.driver.findElement(this.CONTINUE_BUTTON).click();
        return this;
    }
}
