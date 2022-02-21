package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.TestBaseRapor;

public class TestCase02 extends TestBaseRapor {

//2-) 'Hotels Management' ın altında 'Hotel Rooms' seçeneğinin görünürlüğünü kontrol edilmeli

    @Test
    public  void test02(){
        extentTest=extentReports.createTest("HotelRoomsDisplayed");
        HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
        hotelMyCampHotelRooms.hotelManagementButtonElementi.click();
        Assert.assertTrue(hotelMyCampHotelRooms.hotelRoomsButtonElementi.isDisplayed());
        extentTest.pass("Hotel Room  Yazisi Goruldu");


    }

}
