package tests.US_0003;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampRegistration;
import utilities.ConfigReader;
import utilities.Driver;

public class US003_04 {

    HotelMyCampRegistration hotelMyCampRegistration;
    Select select;
    @Test
    public void testcase04(){
        hotelMyCampRegistration = new HotelMyCampRegistration();
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
        hotelMyCampRegistration.passwordTextBox.sendKeys("Es1234567!");
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
        select = new Select(hotelMyCampRegistration.countryDropdown);
        select.selectByVisibleText("United States");
        Assert.assertTrue(hotelMyCampRegistration.stateDropdown.isDisplayed());
        select = new Select(hotelMyCampRegistration.stateDropdown);
        select.selectByVisibleText("Alabama");
        Assert.assertTrue(hotelMyCampRegistration.addresTextBox.isDisplayed());
        hotelMyCampRegistration.addresTextBox.sendKeys(faker.address().fullAddress());
        Assert.assertTrue(hotelMyCampRegistration.workingSectorTextBox.isDisplayed());
        hotelMyCampRegistration.workingSectorTextBox.sendKeys(faker.job().field());
        Assert.assertTrue(hotelMyCampRegistration.birthDateTextBox.isDisplayed());
        hotelMyCampRegistration.birthDateTextBox.sendKeys("22.03.1999");
        Assert.assertTrue(hotelMyCampRegistration.saveButton.isDisplayed());
        hotelMyCampRegistration.saveButton.click();


        Driver.closeDriver();
    }
}
