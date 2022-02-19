package tests.US_0003;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampRegistration;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase01 {
    HotelMyCampRegistration hotelMyCampRegistration = new HotelMyCampRegistration();
    @Test
    public void testcase01(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampRegistration.loginButonu.click();

        hotelMyCampRegistration.createNewAccButton.click();
        Driver.closeDriver();
    }


}
