package tests.US_0004;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMain;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Test01 {


    HotelMyCampMain hotelMyCamp;

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
    public void CreateHotelDisplayed() {

        WebElement createhoteltext = hotelMyCamp.createHotelTextElementi;
        Assert.assertTrue(createhoteltext.isDisplayed());

        String expectedText ="Create Hotel";
        String actualtext = createhoteltext.getText();

        Assert.assertEquals(actualtext,expectedText);



    }













}
