package tests.US_0006;

import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import pages.HotelMyCampHotelRooms;
import pages.HotelMyCampMain;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class US006_01 extends TestBaseRapor {
    HotelMyCampHotelList hotelList = new HotelMyCampHotelList();
    HotelMyCampMain hotelMyCamp ;
    HotelMyCampHotelRooms hotelMyCampHotelRooms = new HotelMyCampHotelRooms();


    //Adresindeki 'Login' buttonu tiklanir. "https://www.hotelmycamp.com/Account/Logon
    //Adresinde dogru username ve password girilerek sisteme giris yapilir."


    @Test
      public void test1() throws InterruptedException {
        hotelMyCamp = new HotelMyCampMain();
          Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
          Thread.sleep(3000);
extentReports.createTest("US_0006","Verilen sitenin Url'i calisyor");
          hotelMyCamp.anasayfaLogin.click();
extentReports.createTest("US_0006","Anasayfa login buttonu calisyor");
          Driver.getDriver().navigate().back();

      }





}

