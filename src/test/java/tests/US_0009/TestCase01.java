package tests.US_0009;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMain;
import pages.HotelMyCampRoomReservation;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase01 extends TestBaseRapor {
    HotelMyCampMain hotelMyCampMain;
    HotelMyCampRoomReservation hotelMyCampRoomReservation;
    Select select;

    @Test
    public void Test01() {
extentTest=extentReports.createTest("LoginTesti");
        hotelMyCampMain = new HotelMyCampMain();
        hotelMyCampMain.loginOl();
        hotelMyCampRoomReservation = new HotelMyCampRoomReservation();
        Assert.assertTrue(hotelMyCampRoomReservation.managerLoginTab.isDisplayed());
extentTest.pass("ManagerOlarakLoginBasarili");
    }

    @Test
    public void Test02() throws InterruptedException {
extentTest=extentReports.createTest("RoomReservationButtonsDisplayTest");
        // tab control
        Assert.assertTrue(hotelMyCampRoomReservation.systemManagementTab.isDisplayed());
extentTest.pass("SystemManagementButtonDisplayed");
        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isDisplayed());
extentTest.pass("HotelManagementButtonDisplayed");
        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isEnabled());
extentTest.pass("HotelManagementButtonEnabled");
        hotelMyCampRoomReservation.hotelManagementTab.click();

        //Assert.assertTrue(hotelMyCampRoomReservation.roomReservationTab.isDisplayed());
        Assert.assertTrue(hotelMyCampRoomReservation.roomReservationTab.isEnabled());
extentTest.pass("RoomReservationButtonEnabled");

        // details button
        hotelMyCampRoomReservation.roomReservationTab.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.listOfReservationsYazisi.isDisplayed());
extentTest.pass("ListofReservationTextDisplayed");
        Thread.sleep(1000);

    }
    @Test
    public void Test03() throws InterruptedException {
extentTest=extentReports.createTest("RoomReservationUpdate");
        // General Data


        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        select = new Select(hotelMyCampRoomReservation.viewAllButtonFirst);
        select.selectByVisibleText("All");
        Thread.sleep(3000);

        hotelMyCampRoomReservation.detailsButtonGetir("1111");
        Thread.sleep(5000);

        Assert.assertTrue(hotelMyCampRoomReservation.editRoomReservationYazisi.isDisplayed());
extentTest.pass("RoomreservationEditButtonDisplayed");
        Thread.sleep(2000);

        select = new Select(hotelMyCampRoomReservation.hotelRoom);
        select.selectByVisibleText("MustafaDRoom1");
        select = new Select(hotelMyCampRoomReservation.user);
        select.selectByVisibleText("cev.det");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(hotelMyCampRoomReservation.price)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.date().toString())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.date().toString())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.number().digit())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression(" "))
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        //hotelMyCampRoomReservation.approved.click();
       // Thread.sleep(1000);
       // hotelMyCampRoomReservation.isPaid.click();
       // Thread.sleep(1000);

      /*Assert.assertFalse(hotelMyCampRoomReservation.approved.isEnabled());
        Assert.assertFalse(hotelMyCampRoomReservation.isPaid.isEnabled());

        Assert.assertFalse(hotelMyCampRoomReservation.approved.isSelected());
        Assert.assertFalse(hotelMyCampRoomReservation.isPaid.isSelected());*/

        Thread.sleep(1000);

        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonGeneralData.isDisplayed());
extentTest.pass("SaveButtonDisplayed");
        hotelMyCampRoomReservation.saveButtonGeneralData.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonGeneralData.isEnabled());
extentTest.pass("SaveButtonEnabled");
    }

    @Test
    public void Test04() throws InterruptedException {
        // property control
       // extentTest=extentReports.createTest("");


        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);

        // save property
        Assert.assertTrue(hotelMyCampRoomReservation.propertiesTab.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.propertiesTab.click();
        Thread.sleep(1000);

        select = new Select(hotelMyCampRoomReservation.selectTip);
        select.selectByVisibleText("Reservation property");
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.click(hotelMyCampRoomReservation.codeProperty)
                .sendKeys(faker.code().asin())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("Info"))
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonProperty.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.saveButtonProperty.click();
        Thread.sleep(2000);
        Assert.assertTrue(hotelMyCampRoomReservation.valueAddedMessage.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.okButton.click();
        Thread.sleep(1000);


        // remove property
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        hotelMyCampRoomReservation.propertiesTab.click();
        Thread.sleep(1000);

        hotelMyCampRoomReservation.removeButtonGetir().click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deleteWarningMessage.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.deleteConfirmOk.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deletedSuccesfullyMessage.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.deletedOkButton.click();
        Thread.sleep(1000);

        // update property
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        hotelMyCampRoomReservation.propertiesTab.click();
        Thread.sleep(2000);

        Select option2 = new Select(hotelMyCampRoomReservation.viewAllButtonSecond);
        option2.selectByVisibleText("All");
        Thread.sleep(1000);

        actions.click(hotelMyCampRoomReservation.codeUpdateLocate())
                .sendKeys(faker.code().asin())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("Update"))
                .perform();

        hotelMyCampRoomReservation.updateButtongetir().click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.updatedSuccesfullyMessage.isDisplayed());
        Thread.sleep(2000);
        hotelMyCampRoomReservation.updatedOkButton.click();
        Thread.sleep(1000);

    }

    @Test
    public void Test05() throws InterruptedException {
        // delete reservation


        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(hotelMyCampRoomReservation.deleteButton.isDisplayed());
        Thread.sleep(1000);
        hotelMyCampRoomReservation.deleteButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deleteButton.isEnabled());
        Thread.sleep(1000);

        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        Driver.closeDriver();

    }

}