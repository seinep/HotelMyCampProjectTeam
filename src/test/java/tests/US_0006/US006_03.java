package tests.US_0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.TestBaseRapor;

public class US006_03 extends TestBaseRapor {

    HotelMyCampHotelRooms hotelMyCampHotelRooms;
    @Test
    public void test3() {
        hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
        hotelMyCampHotelRooms.hotelManagementButtonElementi.click();

extentTest.info("US_0006" +"Management buttonuna tiklama basarili");

        hotelMyCampHotelRooms.hotelRoomsButtonElementi.click();
extentTest.info("Hotel room buttonuna tiklama basarili");
        //  hotelMyCampHotelRooms.addHotelRoomButtonElementi.click();
        Assert.assertTrue(hotelMyCampHotelRooms.addHotelRoomButtonElementi.isDisplayed());
extentReports.createTest("US_0006","Add Hotel Room buttonu gorulmesi basarili");
    }



}
