package tests.US_0007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class US007_05 extends TestBaseRapor {

    HotelMyCampHotelRooms hotelMyCampHotelRooms;
    Select select;
    @Test
    public void test05() throws InterruptedException {
        extentTest=extentReports.createTest("Save-DeleteButonuDisplayed");

        hotelMyCampHotelRooms=new HotelMyCampHotelRooms();


        select=new Select(hotelMyCampHotelRooms.hotelDropDownElementi);
        select.selectByIndex(1);
        String hotelElementiStr=select.getFirstSelectedOption().getText();
        List<WebElement> optionList=select.getOptions();
        for (WebElement each:optionList) {
           if(optionList.contains(hotelElementiStr)){
               Assert.assertTrue(optionList.equals(hotelElementiStr));

           }

        }

        hotelMyCampHotelRooms.codeElementi.clear();
        hotelMyCampHotelRooms.codeElementi.sendKeys("159753");
        hotelMyCampHotelRooms.nameElementi.clear();
        hotelMyCampHotelRooms.nameElementi.sendKeys("Nafiz Han");
        hotelMyCampHotelRooms.locationElementi.clear();
        hotelMyCampHotelRooms.locationElementi.sendKeys("Yozgat");

        hotelMyCampHotelRooms.descriptionElementi.clear();
        hotelMyCampHotelRooms.descriptionElementi.sendKeys("Good Experince Good Holiday");
        hotelMyCampHotelRooms.priceElementi.clear();
        hotelMyCampHotelRooms.priceElementi.sendKeys("6666");

        select=new Select(hotelMyCampHotelRooms.roomTypeDropDownElementi);
        select.selectByIndex(2);
        String roomTypeStr=select.getFirstSelectedOption().getText();
        List<WebElement> optionList2=select.getOptions();
        for (WebElement each:optionList2) {
            if(optionList2.contains(roomTypeStr)){
                Assert.assertTrue(optionList2.equals(roomTypeStr));

            }

        }
        hotelMyCampHotelRooms.maxAdultCountElementi.clear();
        hotelMyCampHotelRooms.maxAdultCountElementi.sendKeys("5");
        hotelMyCampHotelRooms.maxChildCountElementi.clear();
        hotelMyCampHotelRooms.maxChildCountElementi.sendKeys("5");
        hotelMyCampHotelRooms.isAvailableElementi.click();
        hotelMyCampHotelRooms.saveButonuWebElementi.click();
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampHotelRooms.basariliSaveYazisi.isDisplayed());
        extentTest.pass("SaveBasariliYazisiDisplayed");
        hotelMyCampHotelRooms.OKButonElementi.click();


        hotelMyCampHotelRooms.deleteButonuWebElementi.click();
        Thread.sleep(5000);
        hotelMyCampHotelRooms.deleteConfirmButonu.click();
        Thread.sleep(5000);
        Assert.assertTrue(hotelMyCampHotelRooms.basarisizDeleteYazisi.isDisplayed());
        extentTest.pass("DeleteBasarisizYazisiDisplayed");
        hotelMyCampHotelRooms.OKButonElementi.click();


        Driver.closeDriver();


    }
}
