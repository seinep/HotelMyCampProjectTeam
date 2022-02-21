package tests.US_0005;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TestCase02 {
    HotelMyCampHotelList hmclist;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

@Test
    public void test01() throws IOException {

       hmclist = new HotelMyCampHotelList();
    //hmclist.loginOl();

    hmclist.hotelManagementButtonElementi.click();
    ReusableMethods.getScreenshot("deneme");
    ReusableMethods.waitFor(2);
    hmclist.hotelListButtonElementi.click();

    js.executeScript("arguments[0].scrollIntoView()",hmclist.detailsHotelListButonu);
    js.executeScript("arguments[0].click()",hmclist.detailsHotelListButonu);

    //Assert.assertTrue(hmclist.editHotelYazisi.isDisplayed());


}
}
