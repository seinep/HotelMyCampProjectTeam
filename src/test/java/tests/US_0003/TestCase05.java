package tests.US_0003;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampRegistration;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase05 {

    HotelMyCampRegistration hotelMyCampRegistration = new HotelMyCampRegistration();
    @Test
    public void testcase05(){

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampRegistration.loginButonu.click();

        hotelMyCampRegistration.createNewAccButton.click();

        String actualRegisterUrl = Driver.getDriver().getCurrentUrl();
        String expectedRegisterUrl = "https://www.hotelmycamp.com/Account/Register";

        Assert.assertEquals(actualRegisterUrl,expectedRegisterUrl);
        Faker faker = new Faker();

        Assert.assertTrue(hotelMyCampRegistration.registrationFormBaslikYazisi.isDisplayed());

        Assert.assertTrue(hotelMyCampRegistration.usernameTextBox.isDisplayed());
        hotelMyCampRegistration.usernameTextBox.sendKeys(faker.name().username());
        Assert.assertTrue(hotelMyCampRegistration.passwordTextBox.isDisplayed());
        hotelMyCampRegistration.passwordTextBox.sendKeys("Es125687!");
        Assert.assertTrue(hotelMyCampRegistration.emailTextBox.isDisplayed());
        hotelMyCampRegistration.emailTextBox.sendKeys(faker.internet().emailAddress());
        Assert.assertTrue(hotelMyCampRegistration.fullnameTextBox.isDisplayed());
        hotelMyCampRegistration.fullnameTextBox.sendKeys(faker.name().fullName());
        Assert.assertTrue(hotelMyCampRegistration.phoneNoTextBox.isDisplayed());
        hotelMyCampRegistration.phoneNoTextBox.sendKeys(faker.phoneNumber().cellPhone());
        Assert.assertTrue(hotelMyCampRegistration.snnTextBox.isDisplayed());
        hotelMyCampRegistration.snnTextBox.sendKeys(faker.number().digits(9));
        Assert.assertTrue(hotelMyCampRegistration.drivingLicenseTextBox.isDisplayed());
        hotelMyCampRegistration.drivingLicenseTextBox.sendKeys(faker.number().digits(9));
        Assert.assertTrue(hotelMyCampRegistration.countryDropdown.isDisplayed());
        Select select = new Select(hotelMyCampRegistration.countryDropdown);
        select.selectByVisibleText("United States");
        Assert.assertTrue(hotelMyCampRegistration.stateDropdown.isDisplayed());
        Select select1 = new Select(hotelMyCampRegistration.stateDropdown);
        select1.selectByVisibleText("Alabama");
        Assert.assertTrue(hotelMyCampRegistration.addresTextBox.isDisplayed());
        hotelMyCampRegistration.addresTextBox.sendKeys(faker.address().fullAddress());
        Assert.assertTrue(hotelMyCampRegistration.workingSectorTextBox.isDisplayed());
        hotelMyCampRegistration.workingSectorTextBox.sendKeys(faker.job().field());
        Assert.assertTrue(hotelMyCampRegistration.birthDateTextBox.isDisplayed());
        hotelMyCampRegistration.birthDateTextBox.sendKeys("22.03.1999");
        Assert.assertTrue(hotelMyCampRegistration.saveButton.isDisplayed());
        hotelMyCampRegistration.saveButton.click();
        //Assert.assertTrue(hotelMyCampRegistration.sonucYazisiElement.isDisplayed());
        //String expectedSonucYazisi="User Data was inserted successfully";
       System.out.println(hotelMyCampRegistration.sonucYazisiElement.getText());
       // Assert.assertEquals(hotelMyCampRegistration.sonucYazisiElement.getText(),expectedSonucYazisi);
        Driver.getDriver().switchTo().alert().accept();





        //Driver.closeDriver();
    }
}
