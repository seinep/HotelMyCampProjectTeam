package tests.US_0006;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import pages.HotelMyCampHotelRooms;
import pages.HotelMyCampMain;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.openqa.selenium.Keys.TAB;

public class TestCase03 extends TestBaseRapor {

    HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
    @Test
    public void test3() {

        hotelMyCampHotelRooms.hotelManagementButtonElementi.click();

//        extentTest.info("US_0006" +"Management buttonuna tiklama basarili");

        hotelMyCampHotelRooms.hotelRoomsButtonElementi.click();
      //  extentTest.info("Hotel room buttonuna tiklama basarili");
        //  hotelMyCampHotelRooms.addHotelRoomButtonElementi.click();
        Assert.assertTrue(hotelMyCampHotelRooms.addHotelRoomButtonElementi.isDisplayed());
        extentReports.createTest("US_0006","Add Hotel Room buttonu gorulmesi basarili");
    }



}
