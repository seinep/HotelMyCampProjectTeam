package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;

public class TestCase03 {
    //3-)'Hotel Rooms' a click yapıldığında
    // yeni açılan sayfada 'LIST OF HOTELROOMS' yazisinin görünürlüğünü kontrol edilmelidir
@Test
    public void test03(){
    HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
    hotelMyCampHotelRooms.hotelRoomsButtonElementi.click();
    Assert.assertTrue(hotelMyCampHotelRooms.listOfHotelroomsYazisi.isDisplayed());



}


}
