package tests.US_0009;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMain;
import pages.HotelMyCampMainaAnaSayfa;
import pages.HotelMyCampRoomReservation;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase01 {
    HotelMyCampMainaAnaSayfa hotelMyCampMainaAnaSayfa;
    HotelMyCampMain hotelMyCampMain;
    HotelMyCampRoomReservation hotelMyCampRoomReservation;

    @Test
    public void Test01() {
        //  login control
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        hotelMyCampMainaAnaSayfa = new HotelMyCampMainaAnaSayfa();
        hotelMyCampMainaAnaSayfa.anasayfaLogin.click();

        hotelMyCampMain = new HotelMyCampMain();
        hotelMyCampMain.loginOl();

        hotelMyCampRoomReservation = new HotelMyCampRoomReservation();
        hotelMyCampRoomReservation.managerLoginTab.isDisplayed();

    }

    @Test(dependsOnMethods = "Test01")
    public void Test02() throws InterruptedException {
        // tab control
        Assert.assertTrue(hotelMyCampRoomReservation.systemManagementTab.isDisplayed());

        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isDisplayed());
        Assert.assertTrue(hotelMyCampRoomReservation.hotelManagementTab.isEnabled());
        hotelMyCampRoomReservation.hotelManagementTab.click();

        //Assert.assertTrue(hotelMyCampRoomReservation.roomReservationTab.isDisplayed());
        Assert.assertTrue(hotelMyCampRoomReservation.roomReservationTab.isEnabled());

        // details button
        hotelMyCampRoomReservation.roomReservationTab.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.listOfReservationsYazisi.isDisplayed());
        Thread.sleep(1000);

    }
    Select select;
    @Test
    public void Test03() throws InterruptedException {
        // General Data
        Test01();
        Test02();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);

        select = new Select(hotelMyCampRoomReservation.viewAllButtonFirst);
        select.selectByVisibleText("All");
        Thread.sleep(3000);

        hotelMyCampRoomReservation.detailsButtonGetir("1111");
        Thread.sleep(5000);

        Assert.assertTrue(hotelMyCampRoomReservation.editRoomReservationYazisi.isDisplayed());
        Thread.sleep(2000);

        Select select1 = new Select(hotelMyCampRoomReservation.hotelRoom);
        select1.selectByVisibleText("MustafaDRoom1");
        Select select2 = new Select(hotelMyCampRoomReservation.user);
        select2.selectByVisibleText("cev.det");

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
        hotelMyCampRoomReservation.saveButtonGeneralData.click();
        Thread.sleep(1000);
        Assert.assertTrue(hotelMyCampRoomReservation.saveButtonGeneralData.isEnabled());

    }

    @Test
    public void Test04() throws InterruptedException {
        // property control
        Test01();
        Test02();

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
        Test01();
        Test02();

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