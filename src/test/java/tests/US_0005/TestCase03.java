package tests.US_0005;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import utilities.ReusableMethods;

import java.io.IOException;

public class TestCase03 {
    HotelMyCampHotelList hmclist;

    @Test
    public void test01() throws IOException {
        hmclist = new HotelMyCampHotelList();

        ReusableMethods.switchToWindow("Admin - Edit Hotel");

    /*  String ilksyfHandleDegeri = Driver.getDriver().getWindowHandle();
        Set<String> handleSet = Driver.getDriver().getWindowHandles();
        String ikincisyfHandleDegeri = "";
        for (String each : handleSet
        ) {
            if (!each.equals(ilksyfHandleDegeri))
                ikincisyfHandleDegeri = each;
        }
        Driver.getDriver().switchTo().window(ikincisyfHandleDegeri);*/
        ReusableMethods.waitFor(4);

        hmclist.codeKutusuWebElementi.clear();
        ReusableMethods.waitFor(2);

        hmclist.codeKutusuWebElementi.sendKeys("G27");
        hmclist.nameKutusuWebElementi.clear();
        ReusableMethods.waitFor(2);
        hmclist.nameKutusuWebElementi.sendKeys("Titanic Hotel");
        hmclist.addressKutusuWebElementi.clear();
        hmclist.addressKutusuWebElementi.sendKeys("US");
        ReusableMethods.waitFor(2);
        hmclist.phoneKutusuWebElementi.clear();
        hmclist.phoneKutusuWebElementi.sendKeys("+1 408-123-987");
        ReusableMethods.waitFor(2);
        hmclist.emailHotelListKutusuWebElementi.clear();

        hmclist.emailHotelListKutusuWebElementi.sendKeys("titanichtl@gmail.com");

        Select select=new Select(hmclist.idGroupKutusuWebElementi);
        select.selectByVisibleText("Hotel Type2");
        hmclist.saveButonuWebElementi.click();

        ReusableMethods.waitForVisibility(hmclist.alertTexti,10);
        Assert.assertTrue(hmclist.alertTexti.isDisplayed());
        String expectedAlertYazisi="Hotel was updated successfully";

        System.out.println(expectedAlertYazisi);



    }
}