package tests.US_0005;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;

public class TestCase01 {
    HotelMyCampHotelList hmclist;
    Alert alert;


    @Test
    public void test01() throws InterruptedException {
         hmclist = new HotelMyCampHotelList();
         hmclist.loginOl();

        hmclist.hotelManagementButtonElementi.click();
        hmclist.hotelListButtonElementi.click();


        WebElement hotelYaziElementi= hmclist.listofHotelsYazisi;
        Assert.assertTrue(hotelYaziElementi.isDisplayed());


    }
}



