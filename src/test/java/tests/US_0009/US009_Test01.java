package tests.US_0009;

import com.github.javafaker.Faker;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Keys;
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

public class US009_Test01 extends TestBaseRapor {

    HotelMyCampMain hotelMyCampMain;
    HotelMyCampRoomReservation hotelMyCampRoomReservation;
    Select select;

    @Test (priority = 1)
    public void Test01() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("AdminLogin");
        hotelMyCampMain = new HotelMyCampMain();
        hotelMyCampMain.loginOl();
        Thread.sleep(1000);

        hotelMyCampRoomReservation = new HotelMyCampRoomReservation();
        Assert.assertTrue(hotelMyCampRoomReservation.managerLoginTab.isDisplayed());
        extentTest.pass("AdminOlarakLoginBasarili");

        ReusableMethods.getScreenshot("US09/AdminLogin");

    }

    @Test (dependsOnMethods = "Test01")
    public void Test02() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("EditRoomReservationDisplayTest");
        Assert.assertTrue(hotelMyCampRoomReservation.systemManagementTab.isDisplayed());
        extentTest.pass("SystemManagementTabDisplayed");
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isDisplayed());
        extentTest.pass("HotelManagementTabDisplayed");
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isEnabled());
        extentTest.pass("HotelManagementButtonEnabled");
        hotelMyCampRoomReservation.hotelManagementTab.click();
        extentTest.pass("HotelManagementTabClicked");
        Thread.sleep(1000);
        extentTest.pass("RoomReservationTabEnabled");
        Assert.assertTrue(hotelMyCampRoomReservation.roomReservationTab.isEnabled());

        hotelMyCampRoomReservation.roomReservationTab.click();
        Assert.assertTrue(hotelMyCampRoomReservation.listOfReservationsYazisi.isDisplayed());
        extentTest.pass("ListofReservationsTextDisplayed");
        Thread.sleep(1000);

        select = new Select(hotelMyCampRoomReservation.viewAllButtonFirst);
        select.selectByVisibleText("All");
        Thread.sleep(3000);

        hotelMyCampRoomReservation.detailsButtonGetir("1111");
        Thread.sleep(3000);

        Assert.assertTrue(hotelMyCampRoomReservation.editRoomReservationYazisi.isDisplayed());
        extentTest.pass("EditRoomReservationDisplayed");
        Thread.sleep(1000);

        ReusableMethods.getScreenshot("US09/EditRoomReservationTextDisplayed");

    }

    @Test
    public void Test03() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("SaveGeneralData");
        Test01();
        Test02();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

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

        // hotelMyCampRoomReservation.approved.click();
        // Thread.sleep(1000);
        // hotelMyCampRoomReservation.isPaid.click();
        // Thread.sleep(1000);

       /*Assert.assertFalse(hotelMyCampRoomReservation.approved.isEnabled());
        Assert.assertFalse(hotelMyCampRoomReservation.isPaid.isEnabled());

        Assert.assertFalse(hotelMyCampRoomReservation.approved.isSelected());
        Assert.assertFalse(hotelMyCampRoomReservation.isPaid.isSelected());*/

        Thread.sleep(1000);

        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonGeneralData.isDisplayed());
        extentTest.pass("SaveButtonGeneralDataDisplayed");
        hotelMyCampRoomReservation.saveButtonGeneralData.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonGeneralData.isEnabled());
        extentTest.pass("SaveButtonGeneralDataNotWork");

        ReusableMethods.getScreenshot("US09/SaveGeneralData");

    }


    @Test //(dependsOnMethods = "Test03")
    public void Test04() throws InterruptedException, IOException {
        Test01();
        Test02();
extentTest = extentReports.createTest("PropertySaveControl");

        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        Assert.assertTrue(hotelMyCampRoomReservation.propertiesTab.isDisplayed());
        Thread.sleep(1000);
extentTest.pass("PropertiesTabDisplayed");
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
extentTest.pass("SaveButtonPropertyDisplayed");
        hotelMyCampRoomReservation.saveButtonProperty.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.valueAddedMessage.isDisplayed());
extentTest.pass("ValueAddedMessageDisplayed");
        Thread.sleep(1000);
        hotelMyCampRoomReservation.okButton.click();
        Thread.sleep(1000);
extentTest.pass("PropertySaved");

        ReusableMethods.getScreenshot("US09/SaveProperty");


        extentTest = extentReports.createTest("RemoveProperty");
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        hotelMyCampRoomReservation.propertiesTab.click();
        Thread.sleep(1000);

        hotelMyCampRoomReservation.removeButtonGetir().click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deleteWarningMessage.isDisplayed());
        Thread.sleep(1000);
        extentTest.pass("DeleteWarningMessageDisplayed");
        hotelMyCampRoomReservation.deleteConfirmOk.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deletedSuccesfullyMessage.isDisplayed());
        Thread.sleep(1000);
        extentTest.pass("DeletedSuccesfullyMessageDisplayed");
        hotelMyCampRoomReservation.deletedOkButton.click();
        Thread.sleep(1000);
        extentTest.pass("PropertyRemoved");

        ReusableMethods.getScreenshot("US09/RemoveProperty");


        extentTest = extentReports.createTest("PropertyUpdate");
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        hotelMyCampRoomReservation.propertiesTab.click();
        Thread.sleep(2000);

        select = new Select(hotelMyCampRoomReservation.viewAllButtonSecond);
        select.selectByVisibleText("All");
        Thread.sleep(2000);

        actions.click(hotelMyCampRoomReservation.codeUpdateLocate())
                .sendKeys(faker.code().asin())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.expression("Update"))
                .perform();

        hotelMyCampRoomReservation.updateButtongetir().click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.updatedSuccesfullyMessage.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("UpdatedSuccesfullyMessageDisplayed");
        hotelMyCampRoomReservation.updatedOkButton.click();
        Thread.sleep(1000);
        extentTest.pass("PropertyUpdated");

        ReusableMethods.getScreenshot("US09/UpdateProperty");

    }

    @Test //(dependsOnMethods = "Test03")
    public void Test05() throws InterruptedException, IOException {
        Test01();
        Test02();

        extentTest = extentReports.createTest("DeleteReservation");

        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Assert.assertTrue(hotelMyCampRoomReservation.deleteButton.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("DeleteButtonDisplayed");
        hotelMyCampRoomReservation.deleteButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.deleteButton.isEnabled());
        Thread.sleep(1000);
        extentTest.pass("DeleteButtonEnabled");
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);
        extentTest.pass("ReservationNotDeleted");

        ReusableMethods.getScreenshot("US09/DeleteReservation");

        hotelMyCampMain.tearDown();

    }

}