package tests.US_0002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMain;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US002_01 extends TestBaseRapor {

    HotelMyCampMain loginPage;


    @Test(priority = 1)//TC_0001
    public void firstLogIn() throws IOException {
        loginPage = new HotelMyCampMain();
        extentTest=extentReports.createTest("firstLogIn","first login test");//code for TestNG test report
        extentTest.info("login button is displayed"); //code forTestNG test report
        //method name must be written as testName above that is important
        //as description must be written which test is done
        //below code line must be given an info about what was tested

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        Assert.assertTrue(loginPage.logInButon.isDisplayed());
        ReusableMethods.getScreenshot("logInButon");
        System.out.println("Yes, indeed is the login button displayed");

        //Driver.closeDriver();
        //Anasayfadaki sag üstteki navigasyon barinda "Log in" butonu görülebilmelidir-AC1

    }


    @Test(dependsOnMethods = "firstLogIn")//TC_0002
    public void LogInButtonIsEnabled() throws IOException {
        extentTest=extentReports.createTest("LogInButtonIsEnabled","login button enabled");
        extentTest.info("login button is enabled");
       //Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        loginPage.logInButon.click();
        Assert.assertTrue(loginPage.logInYazisi.isEnabled());
        //ReusableMethods.getScreenshot("logInYazisi");
        System.out.println("Yes, indeed is the login button enabled");
        //Driver.closeDriver();
        //Anasayfadaki Log in butonuna tiklandiginda Log in sayfasi acilabilmeli-AC1
    }

    @Test(dependsOnMethods = "LogInButtonIsEnabled")//TC_0003
    public void ifWeSeeLogInText() throws IOException {
        extentTest=extentReports.createTest("ifWeSeeLogInText","white login text displayed");
        extentTest.info("white login text is displayed");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //loginPage.logInButon.click();
        Assert.assertTrue(loginPage.logInYazisi.isDisplayed());
        ReusableMethods.getScreenshot("logInYazisi");
        System.out.println("Yes, indeed is the white login text displayed");
        //Driver.closeDriver();
        //Anasayfadaki Log in butonuna tiklandiginda Log in sayfasinin
        //ortasindaki beyaz renkli Log in yazisi görülebilmelidir-AC1
    }

    @Test(dependsOnMethods = "ifWeSeeLogInText")//TC_0004
    public void seeIfLogInDoItsFunction() throws IOException {
        extentTest=extentReports.createTest("seeIfLogInDoItsFunction","positive smoke test");
        extentTest.info("login successful with valid credentials");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("ValidUserName"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ValidPassword"));
        loginPage.loginButtonElementi.click();
        String actualAfterLoginPageURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualAfterLoginPageURL, "https://www.hotelmycamp.com/Admin/UserAdmin");
        ReusableMethods.getScreenshot("loginButtonElementi");
        //Driver.closeDriver();
        //Gecerli kullanici adi ve sifre girilip Log in buttonuna tiklandiginda
        //basarili bir sekilde giris yapilabilmeli-AC2
    }

    @Test(dependsOnMethods = "seeIfLogInDoItsFunction")//TC_0005
    public void seeIfLISTOFUSERScanBeSeen() throws IOException {
        extentTest=extentReports.createTest("seeIfLISTOFUSERScanBeSeen","Display of LISTOFUSERS text");
        extentTest.info("LISTOFUSERS text is displayed");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        //loginPage.usernameBox.sendKeys(ConfigReader.getProperty("ValidUserName"));
        //loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ValidPassword"));
        //loginPage.loginButtonElementi.click();
        String actualListOfUsersText = loginPage.listOfUsersYazisi.getText();
        Assert.assertEquals(actualListOfUsersText, "LISTOFUSERS");
        ReusableMethods.getScreenshot("listOfUsersYazisi");
        System.out.println("Yes, indeed is the LISTOFUSERS text displayed");
        //Driver.closeDriver();
        //Gecerli kullanici adi ve sifre girilip Log in buttonuna tiklandiginda
        //gidilen sayfadaki tablodaki "LISTOFUSERS" basligi görülmelidir-AC2
    }

    @Test(dependsOnMethods = "seeIfLISTOFUSERScanBeSeen")//TC_0006
    public void seeIf_WrongUsernameMessage_canBeSeen() throws IOException {
        extentTest=extentReports.createTest("seeIf_WrongUsernameMessage_canBeSeen",
                "Display of WrongUsername message");
        extentTest.info("WrongUsername alert text is displayed");
        Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("InvalidUserName1"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("InvalidPassword3"));
        loginPage.loginButtonElementi.click();
        String actualErrorMessageText = loginPage.errorMesaj1.getText()+ "\n"+ loginPage.errorMesaj2.getText();
        Assert.assertTrue(actualErrorMessageText.contains("Try again please"));
        Assert.assertTrue(actualErrorMessageText.contains("Username or password is incorrect, please" +
                " correct them and try again"));
        ReusableMethods.getScreenshot("errorMesaj1");

        System.out.println("The error message is : "+actualErrorMessageText);
        System.out.println("Yes, indeed is the error message text displayed");
        //Driver.closeDriver();
        //Gecersiz bir kullanici adi ve sifresi girip Log in butonuna tikladiginda kullanici
        // adi girisi kutusunun (Username) hemen üzerinde "Try again please Username or password
        // is incorrect, please correct them and try again" yazisini görebilmelidir-AC3

    }

    @Test(dependsOnMethods = "seeIf_WrongUsernameMessage_canBeSeen")//TC_0007
    public void seeIfnewPageURLisCorrect() throws IOException {
        extentTest=extentReports.createTest("seeIfnewPageURLisCorrect","Display of new page URL");
        extentTest.info("New page URL is checked");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        loginPage.usernameBox.clear();
        loginPage.passwordBox.clear();
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("InvalidUserName2"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("InvalidPassword1"));
        loginPage.loginButtonElementi.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().
                equals("https://www.hotelmycamp.com/Admin/Account/LogOnWithCaptcha"));
        //ReusableMethods.getScreenshot("loginButtonElementi");
        System.out.println("Yes, indeed is the page URL of the new page\n: " +
                "https://www.hotelmycamp.com/Admin/Account/LogOnWithCaptcha");
        //Driver.closeDriver();
        //Gecersiz bir kullanici adi ve sifresi girip Log in butonuna tikladiginda acilan
        //sayfanin URL'i "https://www.hotelmycamp.com/Admin/Account/LogOnWithCaptcha" olmalidir-AC3

    }

    @Test(dependsOnMethods = "seeIfnewPageURLisCorrect")//TC_0008
    public void seeIfMessageIsSeenWhenNoUsernameAndNoPasswordWritten() {
        extentTest=extentReports.createTest("seeIfMessageIsSeenWhenNoUsernameAndNoPasswordWritten",
                "Wrong credentials message is displayed");
        extentTest.info("Alert message is displayed");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        loginPage.usernameBox.clear();
        loginPage.passwordBox.clear();
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("NoUsername"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("NoPassword"));
        loginPage.loginButtonElementi.click();

        String actualUsernameUYARIText =loginPage.userNameUyariMesaj.getText();
        String actualPasswordUYARIText =loginPage.passWordUyariMesaj.getText();

        Assert.assertEquals(actualPasswordUYARIText,"This field is required.");
        Assert.assertEquals(actualUsernameUYARIText,"This field is required.");

        System.out.println("Yes, indeed we see both messages:\nThis field is required.");
        //System.out.println(actualPasswordUYARIText);
        //System.out.println(actualUsernameUYARIText);
        //Kullanici Log in sayfasinda ("https://www.hotelmycamp.com/Account/Logon") ise ve
        //kullanici adi ve sifresi girmeden Log in butonuna tiklarsa kullanici adi girisi
        //kutusunun (Username) ve ayni zamanda kullanici sifresi girisi kutusunun (Password)
        //hemen altinda "This field is required." yazisini görebilmelidir-AC4
        //Driver.closeDriver();
        //dd
    }

    @Test(dependsOnMethods = "seeIfMessageIsSeenWhenNoUsernameAndNoPasswordWritten")//TC_0009
    public void seeIfMessageIsSeenWhenCorrectUsernameAndNoPasswordWritten() {
        extentTest=extentReports.createTest("seeIfMessageIsSeenWhenCorrectUsernameAndNoPasswordWritten",
                "Wrong credentials message is displayed 2");
        extentTest.info("Alert message is displayed 2");
        //Driver.getDriver().get(ConfigReader.getProperty("HMCLoginPageURL"));
        loginPage.usernameBox.clear();
        loginPage.passwordBox.clear();
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("ValidUserName"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("NoPassword"));
        loginPage.loginButtonElementi.click();
        String actualPasswordUYARITEXT = loginPage.passWordUyariMesaj3Salih.getText();
        Assert.assertEquals(actualPasswordUYARITEXT,"This field is required.");
        System.out.println("Yes, indeed we see the message:\nThis field is required.");
        System.out.println(actualPasswordUYARITEXT);
        //Kullanici Log in sayfasinda ("https://www.hotelmycamp.com/Account/Logon") ise ve
        //kullanici adini girip ama sifreyi girmeden Log in butonuna tiklarsa sifre girisi
        //kutusunun (Password) hemen altinda "This field is required." yazisini görebilmelidir-AC5
        Driver.closeDriver();
    }





}

