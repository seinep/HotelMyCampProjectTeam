package tests.US_0010;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMain;
import pages.HotelMyCampRoomReservation;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.io.IOException;

public class TestCase01 {

    HotelMyCampMain hotelMyCampMain = new HotelMyCampMain();
    HotelMyCampRoomReservation hotelMyCampRoomReservation = new HotelMyCampRoomReservation();


    //"Hotel Management butonuna tiklandigin da
    //'LIST OF RESERVATIONS' yazisi gorulur"


    @Test(priority = 1)
    public void listReservationsDisplayed() throws IOException {
        hotelMyCampMain.loginOl();

        hotelMyCampMain.hotelManagementButtonElementi.click();
        hotelMyCampMain.bekle(1);
        WebElement roomReservationButton = hotelMyCampMain.roomReservationButtonElementi;

        ReusableMethods.getScreenshot("ListOfReservation");
        Assert.assertTrue(roomReservationButton.isDisplayed());

    }


//"ADD ROOM RESERVATION butonu kullanilabilir
// ve tiklandigin da istenen sayfa'ya gider
//'Create Hotelroomreservatıon'
// yazisi gorunur"

    @Test(priority = 2)
    public void createHotelRoomReservationEnabled() throws IOException {

        hotelMyCampMain.roomReservationButtonElementi.click();

        WebElement addRoomReservationButton = hotelMyCampMain.roomReservationButtonElementi;
        Assert.assertTrue(addRoomReservationButton.isEnabled());

        hotelMyCampMain.addRoomReservationButtonElementi.click();

        ReusableMethods.getScreenshot("CreateHotelRoomResertation");

        WebElement createHotelRoomTextElementi = hotelMyCampRoomReservation.createHotelroomreservatıonText;
        Assert.assertTrue(createHotelRoomTextElementi.isDisplayed());

    }


    @Test(priority = 3)
    public void addReservationData() throws IOException {

        Actions actions =new Actions(Driver.getDriver());

        String selectUser = "manager";
        String selectHotel ="Atlas";

        WebElement selectUserDropDown = hotelMyCampRoomReservation.selectUserDropDown;
        WebElement selectHotelDropDown = hotelMyCampRoomReservation.selectHotelDropDown;
        Select select = new Select(selectUserDropDown);
        select.selectByVisibleText(selectUser);

        select = new Select(selectHotelDropDown);
        select.selectByVisibleText(selectHotel);

        String price="2468";
        hotelMyCampRoomReservation.priceBoxElementi.sendKeys(price);

        String startDate="03/15/2022";
        hotelMyCampRoomReservation.startDateBox.sendKeys(startDate);

        String endDate="03/20/2022";
        hotelMyCampRoomReservation.endDateBox.sendKeys(endDate);
        actions.sendKeys(Keys.ENTER).perform();

        String adultAmount="2";
        hotelMyCampRoomReservation.adultAmountBox.sendKeys(adultAmount);

        String contactNameSurname = "Kartal";
        String contactPhone = "5322567745";
        String contactEmail ="kartal@kartal.com";
        String note="Hello";

        String childAmount="3";
        actions.sendKeys(Keys.TAB).sendKeys(childAmount)
                .sendKeys(Keys.TAB).sendKeys(contactNameSurname)
                .sendKeys(Keys.TAB).sendKeys(contactPhone)
                .sendKeys(Keys.TAB).sendKeys(contactEmail)
                .sendKeys(Keys.TAB).sendKeys(note)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.END).perform();

        JSUtils.scrollDownByJS();
        ReusableMethods.getScreenshot("RoomReservation");

    }

    @Test(priority = 4)
    public void RoomReservationSuccessfully() throws IOException {

        WebElement saveButton = hotelMyCampRoomReservation.saveButonu;
        saveButton.click();

        ReusableMethods.getScreenshot("RoomReservation was inserted successfully");

        String expectedText = "RoomReservation was inserted successfully";
        String actualText = hotelMyCampRoomReservation.alertYazisiElementi.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        hotelMyCampRoomReservation.onayOkTusu.click();







    }




































}
