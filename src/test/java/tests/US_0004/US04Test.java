package tests.US_0004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampHotelList;
import pages.HotelMyCampMain;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US04Test {


    HotelMyCampMain hotelMyCamp;
    HotelMyCampHotelList hotelList;


    @Test (priority = 1)
    public void loginButonuDisplayed() throws IOException {
        hotelMyCamp = new HotelMyCampMain();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        WebElement loginButtonElementi = hotelMyCamp.logInButon;
        Assert.assertTrue(loginButtonElementi.isDisplayed());

        ReusableMethods.getScreenshot("US04/LoginButtonDisplayed");

    }



    @Test (priority = 2,dependsOnMethods = "loginButonuDisplayed")
    public void loginAvailable() {
        hotelMyCamp.logInButon.click();
        WebElement usernameBox = hotelMyCamp.usernameBox;
        WebElement passwordBox = hotelMyCamp.passwordBox;
        WebElement loginButton = hotelMyCamp.loginButtonElementi;

        Assert.assertTrue(usernameBox.isEnabled());
        Assert.assertTrue(passwordBox.isEnabled());
        Assert.assertTrue(loginButton.isDisplayed());

          usernameBox.sendKeys(ConfigReader.getProperty("ValidUserName"));
          passwordBox.sendKeys(ConfigReader.getProperty("ValidPassword"));
          loginButton.click();

        try {
            ReusableMethods.getScreenshot("US04/LoginSuccessful");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 3)
    public void hotelListButtonDisplayed() {

        hotelMyCamp.hotelManagementButtonElementi.click();
        WebElement hotelListButton = hotelMyCamp.hotelListButtonElementi;
        Assert.assertTrue(hotelListButton.isDisplayed());
        Assert.assertTrue(hotelListButton.isEnabled());
        hotelListButton.click();

    }



    @Test(priority = 4)
    public void addHotelDisplayed() {

        WebElement addHotelButton = hotelMyCamp.addHotelButtonElementi;
        Assert.assertTrue(addHotelButton.isDisplayed());
        Assert.assertTrue(addHotelButton.isEnabled());
        addHotelButton.click();

    }



    @Test(priority = 5)
    public void CreateHotelDisplayed() throws IOException {
        hotelList = new HotelMyCampHotelList();
        WebElement createhoteltext = hotelMyCamp.createHotelTextElementi;
        Assert.assertTrue(createhoteltext.isDisplayed());

        ReusableMethods.getScreenshot("US04/Create_Hotel_Displayed");

        String expectedText ="Create Hotel";
        String actualtext = createhoteltext.getText();

        Assert.assertEquals(actualtext,expectedText);

    /*
            "Code: 13579
            Name: Deneme Hotel
            Address: 9 E. Loockerman street, suite 311 Dover, DE 19901
            Phone: 302 718 2180
            Email: info@hotelmycamp.com
            Yukaridaki bilgilerle yeni hotel olusturulacak.
    */

        String code ="13579";
        hotelList.addHotelCodeBoxElementi.sendKeys(code);

        String hotelName = "Deneme Hotel";
        hotelList.addHotelNameBoxElementi.sendKeys(hotelName);

        String hotelAddress ="9 E. Loockerman street, suite 311 Dover, DE 19901";
        hotelList.addHotelAddressBoxElementi.sendKeys(hotelAddress);

        String hotelPhone="302 718 2180";
        hotelList.addHotelPhoneBoxElementi.sendKeys(hotelPhone);

        String hotelMail = "info@hotelmycamp.com";
        hotelList.addHotelEmailBoxElementi.sendKeys(hotelMail);


        WebElement dropDownElementi = hotelList.addHotelIDGroupDropDownElementi;
        Select select = new Select(dropDownElementi);
        select.selectByIndex(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        hotelList.addHotelSaveButtonElementi.click();

        hotelMyCamp.bekle(1);
        ReusableMethods.getScreenshot("US10/Hotel_Save");
        String expectedResultText = "Hotel was inserted successfully";
        String actualResultText = hotelList.addHotelAlertMesajiElementi.getText();
        Assert.assertTrue(actualResultText.contains(expectedResultText));

        WebElement alertOkButtonElementi = hotelList.addHotelAlertOkButtonElementi;
        alertOkButtonElementi.click();



    }



    @Test(priority = 6)
    public void hotelAddControl() throws IOException {

        hotelMyCamp.hotelListButtonElementi.click();

        String code = "13579";

        hotelList.addHotelCodeSearchBoxElementi.sendKeys(code);
        hotelList.addHotelSearchButtonElementi.click();

        String expectedName ="Deneme Hotel";
        String expectedPhone= "302 718 2180";

        hotelMyCamp.bekle(1);

        WebElement actualName = hotelList.webtableNameBox;
        WebElement actualPhone = hotelList.webtablePhoneBox;

        String actualNameText = actualName.getText();
        String actualPhoneText = actualPhone.getText();


        ReusableMethods.getScreenshot("US10/search");

        Assert.assertEquals(actualNameText, expectedName);
        Assert.assertEquals(actualPhoneText, expectedPhone);

        hotelMyCamp.bekle(1);

        Driver.closeDriver();


    }













}
