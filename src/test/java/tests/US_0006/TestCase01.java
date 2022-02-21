package tests.US_0006;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import pages.HotelMyCampHotelRooms;
import pages.HotelMyCampMain;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

import static org.openqa.selenium.Keys.TAB;


public class TestCase01 extends TestBaseRapor {
    HotelMyCampHotelList hotelList = new HotelMyCampHotelList();
    HotelMyCampMain hotelMyCamp = new HotelMyCampMain();
    HotelMyCampHotelRooms hotelMyCampHotelRooms = new HotelMyCampHotelRooms();


    //Adresindeki 'Login' buttonu tiklanir. "https://www.hotelmycamp.com/Account/Logon
    //Adresinde dogru username ve password girilerek sisteme giris yapilir."


    @Test
      public void test1() throws InterruptedException {
          Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
          Thread.sleep(3000);
          extentReports.createTest("US_0006","Verilen sitenin Url'i calisyor");
          hotelMyCamp.anasayfaLogin.click();
          extentReports.createTest("US_0006","Anasayfa login buttonu calisyor");
          Driver.getDriver().navigate().back();

      }





}

