package tests.US_0005;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.io.IOException;

public class US005_01 extends TestBaseRapor {
    HotelMyCampHotelList hmclist;
    Actions actions;


    @Test(priority = 1)
    public void test01() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        extentTest = extentReports.createTest("HMC anasayfaya giris", "gerekli Webelementlere erisim");
        hmclist = new HotelMyCampHotelList();
        hmclist.loginOl();
        extentTest.pass("HMC sayfasina giris yapildi");

        hmclist.hotelManagementButtonElementi.click();
        hmclist.hotelListButtonElementi.click();


        WebElement listOfHotelYazisi = hmclist.listofHotelsYazisi;
        Assert.assertTrue(listOfHotelYazisi.isDisplayed());
        extentTest.pass("List of Hotel Yazisi gorundu");

        hmclist.detailsHotelListButonu.click();

        String editHotelYazisi = hmclist.editHotelYazisi.getText();
        Assert.assertTrue(hmclist.editHotelYazisi.isDisplayed());
        extentTest.pass("Edit Hotel yazisi gorundu");

        ReusableMethods.switchToWindow("Admin - Edit Hotel");
        extentTest.info("Yeni window'a gecis yapildi");


        ReusableMethods.waitFor(1);
        hmclist.codeKutusuWebElementi.clear();
        ReusableMethods.waitFor(1);

        hmclist.codeKutusuWebElementi.sendKeys("G27");
        hmclist.nameKutusuWebElementi.clear();
        ReusableMethods.waitFor(1);
        hmclist.nameKutusuWebElementi.sendKeys("Titanic Hotel");
        hmclist.addressKutusuWebElementi.clear();
        hmclist.addressKutusuWebElementi.sendKeys("US");
        ReusableMethods.waitFor(1);
        hmclist.phoneKutusuWebElementi.clear();
        hmclist.phoneKutusuWebElementi.sendKeys("+1 408-123-987");
        ReusableMethods.waitFor(1);
        hmclist.emailHotelListKutusuWebElementi.clear();
        hmclist.emailHotelListKutusuWebElementi.sendKeys("titanichtl@gmail.com");

        Select select = new Select(hmclist.idGroupKutusuWebElementi);
        select.selectByVisibleText("Hotel Type2");
        hmclist.saveButonuWebElementi.click();
        extentTest.info("Select objesi ile dropdown elementi secildi ve tiklandi");
        JSUtils.scrollIntoVIewJS(hmclist.alertOkayButonu);
        ReusableMethods.waitFor(2);

        js.executeScript("arguments[0].click()", hmclist.alertOkayButonu);

        ReusableMethods.waitForVisibility(hmclist.alertTexti, 10);
        Assert.assertTrue(hmclist.alertTexti.isDisplayed());
        extentTest.pass("Hotel was updated successfully yazisinin gorundugu test edildi");

        ReusableMethods.waitFor(3);
        ReusableMethods.switchToWindow("Admin - List Of Hotels");
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("US05/Son Guncelleme");
        ReusableMethods.waitFor(1);

    }
    @Test(priority = 2 ,dependsOnMethods = "test01")
    public void test02() throws AWTException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        ReusableMethods.switchToWindow("Admin - ListOfUsers");
        extentTest.info("Yeni window'a gecis yapildi");
        ReusableMethods.waitFor(2);
        extentTest.pass("List of Users yazisi gorundugu test edildi");
        ReusableMethods.waitFor(2);

        hmclist.hotelManagementButtonElementi.click();
        extentTest.pass("Hotel Management butonuna basildigi test edildi");
        hmclist.hotelListButtonElementi.click();

        extentTest.pass("Hotel list butonuna basildigi test edildi");
        ReusableMethods.waitFor(1);
       js.executeScript("arguments[0].scrollIntoView()",hmclist.detailsHotelListButonu2);
       js.executeScript("arguments[0].click()",hmclist.detailsHotelListButonu2);
        extentTest.pass("details butonuna basildigi test edildi");
        ReusableMethods.waitFor(1);

        String editHotelYazisi = hmclist.editHotelYazisi.getText();
        Assert.assertTrue(hmclist.editHotelYazisi.isDisplayed());
        extentTest.pass("Edit Hotel yazisi gorundu");

        actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.END).perform();
       //ReusableMethods.waitFor(8);
        hmclist.deleteHotelButonu.click();
        ReusableMethods.clickWithTimeOut(hmclist.deleteAlertOKButonu, 3);




    }
}


