package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_OverViewPage extends PageBase{

    // TODO: constructor to initialize Webdriver
    public P05_OverViewPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using by
    private final By FINISH_BUTTON = By.xpath("(//a)[text()='FINISH']");
    private final By CART_TOTAL_PRICE_WITH_TAX = By.xpath("(//div)[@class='summary_total_label']");

    // TODO: pubic action methods
    public double getTotalPriceFromCart() {
        WebElement totalPriceElement = this.driver.findElement(CART_TOTAL_PRICE_WITH_TAX);
        String totalPriceText = totalPriceElement.getText().replaceAll("[^\\d.]", "");
        return Double.parseDouble(totalPriceText);
    }
    public P05_OverViewPage clickFinishButton() {
        this.driver.findElement(this.FINISH_BUTTON).click();
        return this;
    }
}
