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
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US10Test01 extends TestBaseRapor {

    HotelMyCampMain hotelMyCampMain;
    HotelMyCampRoomReservation hotelMyCampRoomReservation;

//21.022022
    //"Hotel Management butonuna tiklandigin da
    //'LIST OF RESERVATIONS' yazisi gorulur"


    @Test(priority = 1)
    public void listReservationsDisplayed() throws IOException {
extentTest=extentReports.createTest("ReservationListDisplayedTesti");
        hotelMyCampMain = new HotelMyCampMain();
        hotelMyCampMain.loginOl();

        hotelMyCampMain.hotelManagementButtonElementi.click();
        hotelMyCampMain.bekle(1);
        WebElement roomReservationButton = hotelMyCampMain.roomReservationButtonElementi;

        ReusableMethods.getScreenshot("US10/ListOfReservation");
        Assert.assertTrue(roomReservationButton.isDisplayed());
extentTest.pass("RoomReservationButtonDisplayed");
    }


//"ADD ROOM RESERVATION butonu kullanilabilir
// ve tiklandigin da istenen sayfa'ya gider
//'Create Hotelroomreservatıon'
// yazisi gorunur"

    @Test(priority = 2)
    public void createHotelRoomReservationEnabled() throws IOException {
extentTest=extentReports.createTest("CreateHotelRoomReservation");
        hotelMyCampRoomReservation = new HotelMyCampRoomReservation();
        hotelMyCampMain.roomReservationButtonElementi.click();

        WebElement addRoomReservationButton = hotelMyCampMain.roomReservationButtonElementi;
        Assert.assertTrue(addRoomReservationButton.isEnabled());
extentTest.pass("addRoomReservationButtonEnabled");
        hotelMyCampMain.addRoomReservationButtonElementi.click();

        ReusableMethods.getScreenshot("US10/CreateHotelRoomResertation");

        WebElement createHotelRoomTextElementi = hotelMyCampRoomReservation.createHotelroomreservationText;
        Assert.assertTrue(createHotelRoomTextElementi.isDisplayed());
extentTest.pass("createHotelRoomTextDisplayed");
    }


    @Test(priority = 3)
    public void addReservationData() throws IOException {
extentTest=extentReports.createTest("addRoomReservationData");
        hotelMyCampRoomReservation = new HotelMyCampRoomReservation();
        Actions actions = new Actions(Driver.getDriver());

        String selectUser = "manager";
        String selectHotel = "Atlas";

        WebElement selectUserDropDown = hotelMyCampRoomReservation.selectUserDropDown;
        WebElement selectHotelDropDown = hotelMyCampRoomReservation.selectHotelDropDown;
        Select select = new Select(selectUserDropDown);
        select.selectByVisibleText(selectUser);

        select = new Select(selectHotelDropDown);
        select.selectByVisibleText(selectHotel);

        String price = "2468";
        hotelMyCampRoomReservation.priceBoxElementi.sendKeys(price);

        String startDate = "03/15/2022";
        hotelMyCampRoomReservation.startDateBox.sendKeys(startDate);

        String endDate = "03/20/2022";
        hotelMyCampRoomReservation.endDateBox.sendKeys(endDate);
        actions.sendKeys(Keys.ENTER).perform();

        String adultAmount = "2";
        hotelMyCampRoomReservation.adultAmountBox.sendKeys(adultAmount);

        String contactNameSurname = "Kartal";
        String contactPhone = "5322567745";
        String contactEmail = "kartal@kartal.com";
        String note = "Hello";

        String childAmount = "3";
        actions.sendKeys(Keys.TAB).sendKeys(childAmount)
                .sendKeys(Keys.TAB).sendKeys(contactNameSurname)
                .sendKeys(Keys.TAB).sendKeys(contactPhone)
                .sendKeys(Keys.TAB).sendKeys(contactEmail)
                .sendKeys(Keys.TAB).sendKeys(note)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .perform();
        actions.sendKeys(Keys.END).perform();


        ReusableMethods.getScreenshot("US10/RoomReservation");
extentTest.info("ReservationBilgileriGirildi");
    }

    @Test(priority = 4)
    public void RoomReservationSuccessfully() throws IOException {
extentTest=extentReports.createTest("RoomReservationSuccessfully");
        WebElement saveButton = hotelMyCampRoomReservation.saveButonu;
        saveButton.click();

        hotelMyCampMain.bekle(1);
        ReusableMethods.getScreenshot("US10/RoomReservationSuccessfully");
extentTest.info("RoomReservationSuccessfullyText");
        // String expectedText = "RoomReservation was inserted successfully";
        //  String actualText = hotelMyCampRoomReservation.alertYazisiElementi.getText();

        //  Assert.assertTrue(actualText.contains(expectedText));

        hotelMyCampRoomReservation.onayOkTusu.click();


    }

    //Girilen veriler tabloda gorunur
    @Test(priority = 5)
    public void addDataDisplayed() throws IOException {
extentTest=extentReports.createTest("addDataDisplayed");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();

        hotelMyCampMain.bekle(1);
        hotelMyCampMain.roomReservationButtonElementi.click();

        String contactNameSurname ="Kartal";
        String contactPhone ="(225) 677-4553";
        String contactEmail = "kartal@kartal.com";

        hotelMyCampRoomReservation.contactNameSurnameSearchBox.sendKeys(contactNameSurname);

        actions.sendKeys(Keys.TAB).sendKeys(contactPhone)
                .sendKeys(Keys.TAB).sendKeys(contactEmail)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        hotelMyCampMain.bekle(1);

        ReusableMethods.getScreenshot("US10/WebtableSearch");
extentTest.info("WebtableSearchEdildi");

        String actualContactName = hotelMyCampRoomReservation.webtableContactName.getText();
        Assert.assertEquals(actualContactName, contactNameSurname);
extentTest.pass("Webtable icinde girilen isim goruldu");
        String actualContactPhone=hotelMyCampRoomReservation.webtableContactPhone.getText();
        Assert.assertEquals(actualContactPhone, contactPhone);
extentTest.pass("Webtable icinde girilen telefon numarasi goruldu");

        String actualContactEmail = hotelMyCampRoomReservation.webtableContactEmail.getText();
        Assert.assertEquals(actualContactEmail,contactEmail);
extentTest.pass("Webtable icinde girilen email adresi goruldu");


Driver.closeDriver();

    }

























}
