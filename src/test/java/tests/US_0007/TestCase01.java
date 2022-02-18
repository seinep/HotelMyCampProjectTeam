package tests.US_0007;

import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase01 {
//1-) https://www.hotelmycamp.com anasayfasinda 'Log in' butonu görünür olmali.
// 'Log in' butonuna tiklayip gecerli  bilgiler kullanılarak 'admin' sayfasina erisim saglanabilmeli.

    @Test
    public void test01(){


        HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
        hotelMyCampHotelRooms.loginOl();


    }


}
