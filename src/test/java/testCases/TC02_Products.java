package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static drivers.DriverHolder.getDriver;
import static util.Utility.generateRandomFirstName;
import static util.Utility.generateRandomPostcode;

public class TC02_Products extends TestBase {

    String firsName = generateRandomFirstName();
    String lasName = generateRandomFirstName();
    String postCode = generateRandomPostcode();

    @Test(priority = 1, description = "Add product from products page to cart")
    public void verifyUserAddProductToCart_P() throws InterruptedException {
        // TODO: login to website
        new P01_LoginPage(getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginButton();
        // TODO: add product and go to shopping cart
        double expectedTotalPrice = new P02_ProductsPage(getDriver())
                .addProductsToCart();
        //TODO: sleep 2sec
        Thread.sleep(3000);
        new P02_ProductsPage(getDriver())
                .goToShoppingCart();
        // TODO: go to checkout page
        new P03_CartPage( getDriver())
                .goToCheckoutPage();
        // TODO: fill checkout data and go to overview page
        new P04_CheckOutPage( getDriver())
                .enterFirstName(firsName)
                .enterLastName(lasName)
                .enterPostalCode(postCode)
                .clickContinueButton();
        //TODO: sleep 2sec
        Thread.sleep(3000);
        // TODO: complete order and click on finish
        double actualTotalPrice = new P05_OverViewPage(getDriver())
                .getTotalPriceFromCart();
        new P05_OverViewPage( getDriver())
                .clickFinishButton();
        //TODO: assert
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, 0.01, "The total price in the cart does not match the expected total price!");
        Assert.assertTrue(getDriver().getPageSource().contains("THANK YOU FOR YOUR ORDER"));
        //TODO: print the actual and expected result
        System.out.println("The actual total price with tax is: " + actualTotalPrice + " and the expected total price with tax is: " + expectedTotalPrice);
    }
}