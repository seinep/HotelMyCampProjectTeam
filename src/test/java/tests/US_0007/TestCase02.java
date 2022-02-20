package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;

public class TestCase02 {

//2-) 'Hotels Management' ın altında 'Hotel Rooms' seçeneğinin görünürlüğünü kontrol edilmeli

HotelMyCampHotelRooms hotelMyCampHotelRooms;
    @Test
    public  void test01(){
        hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
        hotelMyCampHotelRooms.hotelManagementButtonElementi.click();
        Assert.assertTrue(hotelMyCampHotelRooms.hotelRoomsButtonElementi.isDisplayed());



    }

}
