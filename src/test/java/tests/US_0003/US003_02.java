package tests.US_0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampRegistration;
import utilities.ConfigReader;
import utilities.Driver;

public class US003_02 {

    HotelMyCampRegistration hotelMyCampRegistration;
    @Test
    public void testcase02(){

        hotelMyCampRegistration = new HotelMyCampRegistration();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampRegistration.loginButonu.click();

        hotelMyCampRegistration.createNewAccButton.click();

        String actualRegisterUrl = Driver.getDriver().getCurrentUrl();
        String expectedRegisterUrl = "https://www.hotelmycamp.com/Account/Register";

        Assert.assertEquals(actualRegisterUrl,expectedRegisterUrl);

        Driver.closeDriver();
    }
}
