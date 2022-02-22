package tests.US_0007;

import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.TestBaseRapor;

public class US007_01 extends TestBaseRapor {
//1-) https://www.hotelmycamp.com anasayfasinda 'Log in' butonu görünür olmali.
// 'Log in' butonuna tiklayip gecerli  bilgiler kullanılarak 'admin' sayfasina erisim saglanabilmeli.

HotelMyCampHotelRooms hotelMyCampHotelRooms;
    @Test
    public void test01(){

        extentTest=extentReports.createTest("LoginButonuDisplayed");
        hotelMyCampHotelRooms=new HotelMyCampHotelRooms();
        hotelMyCampHotelRooms.loginOl();


    }


}
