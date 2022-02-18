package tests.US_0007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelRooms;

import java.util.List;

public class TestCase05 {
    @Test
    public void test05() throws InterruptedException {
        HotelMyCampHotelRooms hotelMyCampHotelRooms=new HotelMyCampHotelRooms();





        Select select=new Select(hotelMyCampHotelRooms.hotelDropDownElementi);
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

        Select select2=new Select(hotelMyCampHotelRooms.roomTypeDropDownElementi);
        select2.selectByIndex(2);
        String roomTypeStr=select2.getFirstSelectedOption().getText();
        List<WebElement> optionList2=select2.getOptions();
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
        hotelMyCampHotelRooms.OKButonElementi.click();


        hotelMyCampHotelRooms.deleteButonuWebElementi.click();
        Thread.sleep(5000);
        hotelMyCampHotelRooms.deleteConfirmButonu.click();
        Thread.sleep(5000);
        Assert.assertTrue(hotelMyCampHotelRooms.basarisizDeleteYazisi.isDisplayed());
        hotelMyCampHotelRooms.OKButonElementi.click();





    }
}
