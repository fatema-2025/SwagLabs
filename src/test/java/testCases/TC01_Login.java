package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import static drivers.DriverHolder.getDriver;

public class TC01_Login extends TestBase{

    @Test(priority = 1, description = "Login with valid data")
    public void loginWithValidData_P() throws InterruptedException {
        new P01_LoginPage (getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginButton();
        //TODO: sleep 2sec
        Thread.sleep(3000);
        //TODO: assert login
        Assert.assertTrue(getDriver().findElement(By.xpath("(//div)[@class=\"product_label\"]")).isDisplayed());
    }

    @Test(priority = 2, description = "Fill only password field then click login")
    public void loginWithEmptyUserName_P() throws InterruptedException {
        new P01_LoginPage (getDriver())
                .enterPassword(password)
                .clickLoginButton();
        //TODO: sleep 2sec
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "Login with invalid data")
    public void loginWithInValidData_P() throws InterruptedException {
        //TODO: reinitialize username and password with invalid data
        username = "asjsjs";
        password = "secret";
        new P01_LoginPage (getDriver())
                .enterUserName(username)
                .enterPassword(password)
                .clickLoginButton();
        //TODO: sleep 2sec
        Thread.sleep(2000);
    }
}
