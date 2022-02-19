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

public class Test01 {


    HotelMyCampMain hotelMyCamp;
    HotelMyCampHotelList hotelList;

    @Test (priority = 1)
    public void loginButonuDisplayed() throws IOException {
        hotelMyCamp = new HotelMyCampMain();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        WebElement loginButtonElementi = hotelMyCamp.logInButon;
        Assert.assertTrue(loginButtonElementi.isDisplayed());

        ReusableMethods.getScreenshot("LoginButtonDisplayed");

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
            ReusableMethods.getScreenshot("LoginSuccessful");
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

//TC0003
//"https://www.hotelmycamp.com/admin/HotelAdmin/Create/
//adresinde 'Create Hotel' yazisi gorunuyor olmali."

    @Test(priority = 5)
    public void CreateHotelDisplayed() throws IOException {

        WebElement createhoteltext = hotelMyCamp.createHotelTextElementi;
        Assert.assertTrue(createhoteltext.isDisplayed());

        ReusableMethods.getScreenshot("Create_Hotel_Displayed");

        String expectedText ="Create Hotel";
        String actualtext = createhoteltext.getText();

        Assert.assertEquals(actualtext,expectedText);

    }

    @Test(priority = 6)
    public void hotelAdd01() throws IOException {

       // String code ="13579";
        hotelList.addHotelCodeBoxElementi.sendKeys("13579");

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
        ReusableMethods.getScreenshot("Hotel_Save");
        String expectedResultText = "Hotel was inserted successfully";
        String actualResultText = hotelList.addHotelAlertMesajiElementi.getText();
        Assert.assertTrue(actualResultText.contains(expectedResultText));

        WebElement alertOkButtonElementi = hotelList.addHotelAlertOkButtonElementi;
        alertOkButtonElementi.click();
    }













}
