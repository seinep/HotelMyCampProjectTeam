package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.TestBaseRapor;

public class TestCase03 extends TestBaseRapor {
    //3-)'Hotel Rooms' a click yapıldığında
    // yeni açılan sayfada 'LIST OF HOTELROOMS' yazisinin görünürlüğünü kontrol edilmelidir
@Test
    public void test03(){
    extentTest=extentReports.createTest("LISTOFHOTELROOMSDisplayed");
    HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
    hotelMyCampHotelRooms.hotelRoomsButtonElementi.click();
    Assert.assertTrue(hotelMyCampHotelRooms.listOfHotelroomsYazisi.isDisplayed());
    extentTest.pass("LIST OF HOTELROOMS Goruldu");


}


}
