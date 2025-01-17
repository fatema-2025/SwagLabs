package testCases;

import drivers.DriverFactory;
import org.testng.annotations.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {
    String username = "standard_user";
    String password = "secret_sauce";

    @Parameters("browsername")
    @BeforeTest
    public void setupDriver(@Optional String browsername) throws AWTException {
        setDriver(DriverFactory.getNewInstance(browsername));
        getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        getDriver().get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
    }
}

