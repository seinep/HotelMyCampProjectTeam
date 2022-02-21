package tests.US_0006;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import pages.HotelMyCampHotelRooms;
import pages.HotelMyCampMain;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

import static org.openqa.selenium.Keys.TAB;

public class TestCase04 extends TestBaseRapor {
    HotelMyCampHotelList hotelList = new HotelMyCampHotelList();
    HotelMyCampMain hotelMyCamp = new HotelMyCampMain();
    HotelMyCampHotelRooms hotelMyCampHotelRooms = new HotelMyCampHotelRooms();
    TestCase03 testCase03=new TestCase03();
    Faker faker = new Faker();
    public String idstring = faker.idNumber().invalid();

    @Test
    public void test4() throws InterruptedException {
        hotelMyCampHotelRooms.addHotelRoomButtonElementi.click();
    //    extentTest.info("US_0006" + "Add Hotel Room buttonu tiklama basarili");
        Select select = new Select(hotelMyCampHotelRooms.hotelDropDownElementi);
        select.selectByIndex(1);
        Actions action = new Actions(Driver.getDriver());

        action.sendKeys(TAB);


        hotelMyCampHotelRooms.codeElementi.sendKeys(idstring + TAB);
        hotelMyCampHotelRooms.nameElementi.sendKeys(faker.name().firstName() + TAB);
        hotelMyCampHotelRooms.locationElementi.sendKeys(faker.address().country().toUpperCase() + TAB);
        hotelMyCampHotelRooms.descriptionElementi.sendKeys(faker.book().publisher() + TAB);
        hotelMyCampHotelRooms.priceElementi.sendKeys("300" + TAB);
        hotelMyCampHotelRooms.roomTypeDropDownElementi.click();
        Select select2 = new Select(hotelMyCampHotelRooms.roomTypeDropDownElementi);
        select2.selectByIndex(1);
        action.sendKeys(TAB);
        hotelMyCampHotelRooms.maxAdultCountElementi.sendKeys(faker.number().digits(8) + TAB);
        hotelMyCampHotelRooms.maxChildCountElementi.sendKeys(faker.number().digits(8) + TAB);
        hotelMyCampHotelRooms.isAvailableElementi.click();
        hotelMyCampHotelRooms.isAvailableElementi.submit();
        action.sendKeys(Keys.DOWN);
        action.sendKeys(Keys.DOWN);
        extentReports.createTest("US_0006","Veri girmeleri basarili");
        hotelMyCampHotelRooms.saveButonuWebElementi1.click();
     //   extentTest.info("US_0006"+"Save buttonuna tiklama basarili");
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampHotelRooms.successfullElementi.isDisplayed());
        extentReports.createTest("US_0006","Save basarili");
        hotelMyCampHotelRooms.OKButonElementi.click();
        Driver.getDriver().navigate().back();




    }
    @Test
    public void test5() throws IOException {
      //  extentTest.info("US_0006"+"Ekledigimiz odanin gercekten eklenip eklenmedigi gorulur");
        hotelMyCampHotelRooms.code2Elementi.click();
        hotelMyCampHotelRooms.code2Elementi.sendKeys(idstring);
     //   extentTest.info("US_0006"+"Girdigimiz Code ile Arama yaparak bulabiliriz ekledigimiz odayi");
        hotelMyCampHotelRooms.search2Elementi.click();
        ReusableMethods.getScreenshot("US_0006/Ekleme basarili");
        extentReports.createTest("US_0006","Odamiz duzgun bir sekilde eklenmistir");


    }

}
