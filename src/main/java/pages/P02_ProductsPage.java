package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static util.Utility.generateRandomInt;

public class P02_ProductsPage extends PageBase {

    // TODO: constructor to initialize Webdriver
    public P02_ProductsPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using by
    private final By PRODUCT_BUTTON = By.xpath("(//button)[text()=\"ADD TO CART\"]");
    private final By CART_BUTTON = By.xpath("(//div/a)[1]");
    private final By PRODUCT_PRICE = By.xpath("//div[@class='inventory_item_price']");

    // TODO: pubic action methods
    public double addProductsToCart() {
        List<WebElement> productButtons = this.driver.findElements(PRODUCT_BUTTON);
        List<WebElement> productPrices = this.driver.findElements(PRODUCT_PRICE);
        int numProducts = productButtons.size();
        int numProductsToAdd = generateRandomInt(numProducts) + 1;
        int productsAdded = 0;
        Set<Integer> selectedIndices = new HashSet<>();
        double totalPrice = 0.0;

        while (productsAdded < numProductsToAdd) {
            int randomIndex = generateRandomInt(numProducts);
            if (!selectedIndices.contains(randomIndex)) {
                selectedIndices.add(randomIndex);
                WebElement randomProductButton = productButtons.get(randomIndex);
                randomProductButton.click();

                WebElement productPriceElement = productPrices.get(randomIndex);
                String priceText = productPriceElement.getText().replaceAll("[^\\d.]", "");  // Clean the price string
                double productPrice = Double.parseDouble(priceText);
                double taxAmount = productPrice * 0.08;

                totalPrice += (productPrice + taxAmount);
                productsAdded++;
            }
        }
        System.out.println("Total products added to the cart: " + productsAdded);
        return totalPrice;
    }

    public P02_ProductsPage goToShoppingCart() {
        this.driver.findElement(this.CART_BUTTON).click();
        return this;
        }
    }
