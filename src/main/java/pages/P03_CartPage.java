package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage extends PageBase{

    // TODO: constructor to initialize Webdriver
    public P03_CartPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using by
    private final By CHECKOUT_BUTTON = By.xpath("(//a)[text()='CHECKOUT']");

    // TODO: pubic action methods
    public P03_CartPage goToCheckoutPage() {
        this.driver.findElement(this.CHECKOUT_BUTTON).click();
        return this;
    }
}
