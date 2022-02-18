package tests.US_0007;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;

public class TestCase04 {
   // 4-)İstenilen hotel için 'DETAİLS' a click yapılmalı ve
   // yeni  açılan sayfada 'Edit Hotelroom' yazisini görünürlüğü kontrol edilmelidir
@Test
    public void test04(){
    HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();

    hotelMyCampHotelRooms.detailsButonu.click();
    Assert.assertTrue(hotelMyCampHotelRooms.editHotelRoomYaziElementi.isDisplayed());




}

}
