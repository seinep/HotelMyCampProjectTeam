package tests.US_0001;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampMainaAnaSayfa;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US001_01 extends TestBaseRapor {
    ////1.  https://www.hotelmycamp.com/ adresine gidilir  ve
//// home,Rooms,Restarurant,AboutBlog,Contact ve Log in butonları görüyor mu dıye bakılır

    HotelMyCampMainaAnaSayfa hotelMyCampMainaAnaSayfa;
    /*  @BeforeSuitenaSayfa;

      public  void url() {


      }

      @AfterSuite
      public void url1() {
          Driver.closeDriver();
      }*/
    @Test
    public void isDisPlayedTesti1() throws InterruptedException {
extentTest=extentReports.createTest("DisplayedTest");
        hotelMyCampMainaAnaSayfa=new HotelMyCampMainaAnaSayfa();
        hotelMyCampMainaAnaSayfa.anaSayfaUrl();
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.homeButton.isDisplayed());
extentTest.pass("HomeButtonDisplayed");
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.roomsButton.isDisplayed());
extentTest.pass("RoomsButtonDisplayed");
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.restaurantButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.aboutButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.contactButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.anasayfaLogin.isDisplayed());


        Thread.sleep(3000);
    }

    //2. https://www.hotelmycamp.com/ adresine gidilir ve
    // Navbar'daki butonlara tıklanır ilgili sayfaya gidip gitmediği kontrol edilir

    @Test //(dependsOnMethods = "isDisplayedTesti1")
    public void isDisPlayedTesti2() throws InterruptedException {

        HotelMyCampMainaAnaSayfa hotelMyCampMainaAnaSayfa=new HotelMyCampMainaAnaSayfa();

        hotelMyCampMainaAnaSayfa.roomsButton.click();
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.roomSayfaControl.isDisplayed());

        hotelMyCampMainaAnaSayfa.restaurantButton.click();
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.restaurantSayfaControl.isDisplayed());

        hotelMyCampMainaAnaSayfa.aboutButton.click();
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.hotelmycamp.com/content/about";
        Assert.assertEquals(actualUrl,expectedUrl);

        hotelMyCampMainaAnaSayfa.contactButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.contactSayfaControl.isDisplayed());

        hotelMyCampMainaAnaSayfa.anasayfaLogin.click();
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.logInSayfaControl.isDisplayed());



        Thread.sleep(3000);




    }

    //3.Ana sayfadaki check-in date,check-out date,room,customer elementlerinin var olup olmadığına bakılır kontrol edılır



    @Test //(dependsOnMethods = "isDisplayedTesti2")
    public void isDisPlayedTesti3() throws InterruptedException {

        hotelMyCampMainaAnaSayfa = new HotelMyCampMainaAnaSayfa();
        hotelMyCampMainaAnaSayfa.anaSayfaUrl();

        Assert.assertTrue(hotelMyCampMainaAnaSayfa.checkİnDateButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.checkOutDateButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.roomTypeButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.customerButton.isDisplayed());
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.checkAvailabilityButton.isDisplayed());


        hotelMyCampMainaAnaSayfa.checkİnDateButton.click();
        hotelMyCampMainaAnaSayfa.checkİnDateButton.clear();
        hotelMyCampMainaAnaSayfa.checkİnDateButton.click();
        hotelMyCampMainaAnaSayfa.checkİnDateButton.sendKeys("4/28/2022");
        hotelMyCampMainaAnaSayfa.checkOutDateButton.click();
        hotelMyCampMainaAnaSayfa.checkOutDateButton.clear();
        hotelMyCampMainaAnaSayfa.checkOutDateButton.click();
        hotelMyCampMainaAnaSayfa.checkOutDateButton.sendKeys("4/29/2022");


        Select select = new Select(hotelMyCampMainaAnaSayfa.roomTypeButton);
        select.selectByVisibleText("Single");
        Select select1 = new Select(hotelMyCampMainaAnaSayfa.customerButton);
        select1.selectByValue("1");

        //4.Gerekli işlemleden sonra check availabiity butonun click sonrası
        // ilgili sayfaya yönlendirip yönlendirmediği kontrol edilirve
        // update edilip edilmediğine bakılır
        hotelMyCampMainaAnaSayfa.checkAvailabilityButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.updateControl.isDisplayed());
        Driver.getDriver().navigate().back();

        Thread.sleep(3000);


    }
    @Test//(dependsOnMethods = "isDisPlayedTesti3")
    public void isDisPlayedTesti4() throws InterruptedException {
        HotelMyCampMainaAnaSayfa hotelMyCampMainaAnaSayfa = new HotelMyCampMainaAnaSayfa();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window.scrollBy(0,400)");
        Thread.sleep(5000);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.welcomeToOur.isDisplayed());

        //6.Ana sayfadaki our rooms bölümüne gidilir ve altındakı seçeneklere tıklanır

        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails1);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol1.isDisplayed());
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);

        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails2);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol2.isDisplayed());
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);


        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails3);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol3.isDisplayed());
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);


        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails4);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol4.isDisplayed());
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);


        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails5);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol5.isDisplayed());
        Driver.getDriver().navigate().back();

        Thread.sleep(3000);


        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.viewRoomDetails6);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.viewRoomDetailsKontrol6.isDisplayed());
        // javascriptExecutor.executeScript("window.scrollBy(0,-400)");
        Driver.getDriver().navigate().back();
    }
    @Test //(dependsOnMethods = "isDisplayedTesti4")
    public void isDisPlayedTesti5() throws InterruptedException {
        HotelMyCampMainaAnaSayfa hotelMyCampMainaAnaSayfa = new HotelMyCampMainaAnaSayfa();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();

        javascriptExecutor.executeScript("window.scrollBy(0,3200)");
        Thread.sleep(5000);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.sliderBolumu.isDisplayed());

        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.sliderBölümüButton1);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.sliderBölümüButton1.isEnabled());


        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.sliderBölümüButton2);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.sliderBölümüButton2.isEnabled());

        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.sliderBölümüButton3);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.sliderBölümüButton3.isEnabled());

        javascriptExecutor.executeScript("arguments[0].click();", hotelMyCampMainaAnaSayfa.sliderBölümüButton4);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.sliderBölümüButton4.isEnabled());


//8.Recent Blog bölümü görünüp görünmediği kontrol edilir ve içerisindeki elementler tıklanıyor mu bakılır
        javascriptExecutor.executeScript("window.scrollBy(0,+350)");
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.recentBlog.isDisplayed());

        hotelMyCampMainaAnaSayfa.getRecentBlog1.click();
        String actualTitle1 = Driver.getDriver().getTitle();
        String expectedTitle1 = "Even the all-powerful Pointing has no control about the blind texts 6";
        Assert.assertTrue(actualTitle1.contains(expectedTitle1));
        Driver.getDriver().navigate().back();

        hotelMyCampMainaAnaSayfa.getRecentBlog2.click();
        String actualTitle2 = Driver.getDriver().getTitle();
        String expectedTitle2 = "Even the all-powerful Pointing has no control about the blind texts 5";
        Assert.assertTrue(actualTitle2.contains(expectedTitle2));
        Driver.getDriver().navigate().back();

        hotelMyCampMainaAnaSayfa.getRecentBlog3.click();
        String actualTitle3 = Driver.getDriver().getTitle();
        String expectedTitle3 = "Even the all-powerful Pointing has no control about the blind texts 4";
        Assert.assertTrue(actualTitle3.contains(expectedTitle3));
        Driver.getDriver().navigate().back();

        hotelMyCampMainaAnaSayfa.getRecentBlog4.click();
        String actualTitle4 = Driver.getDriver().getTitle();
        String expectedTitle4 = "Even the all-powerful Pointing has no control about the blind texts 3";
        Assert.assertTrue(actualTitle4.contains(expectedTitle4));





    }
    @Test//(dependsOnMethods = "isDisplayedTesti5")
    public void zinstgramTesti() throws IOException {

        hotelMyCampMainaAnaSayfa=new HotelMyCampMainaAnaSayfa();



        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) Driver.getDriver();
        //  javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",hotelMyCampMainaAnaSayfa.instgramResim1);
        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.instgramResim1);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.instgramResim1.isEnabled());

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.instgramResim2);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.instgramResim2.isEnabled());

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.instgramResim3);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.instgramResim3.isEnabled());

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.instgramResim4);
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.instgramResim4.isEnabled());




    }
    //10.Sayfanın en altındakı footer bolümü görünür mü bakılır ve
    // içerisindeki elementler tıklanıp tıklanmadığu kontrol edilir
    @Test//(dependsOnMethods = "instgramTesti")
    public void zinstgramTesti2() {
        hotelMyCampMainaAnaSayfa=new HotelMyCampMainaAnaSayfa();
        hotelMyCampMainaAnaSayfa.anaSayfaUrl();
        Assert.assertTrue(hotelMyCampMainaAnaSayfa.footerBölümü.isDisplayed());

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerEmail);
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl,expectedUrl);

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerPhone);
        String actualUrl1=Driver.getDriver().getCurrentUrl();
        String expectedUrl1="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl1,expectedUrl1);

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerPrivacyAboutUs);
        String actualUrl2=Driver.getDriver().getCurrentUrl();
        String expectedUrl2="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl2,expectedUrl2);

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerPrivacyCareer);
        String actualUrl3=Driver.getDriver().getCurrentUrl();
        String expectedUrl3="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl3,expectedUrl3);

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerPrivacyContactUs);
        String actualUrl4=Driver.getDriver().getCurrentUrl();
        String expectedUrl4="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl4,expectedUrl4);

        javascriptExecutor.executeScript("arguments[0].click();",hotelMyCampMainaAnaSayfa.footerPrivacyServices);
        String actualUrl5=Driver.getDriver().getCurrentUrl();
        String expectedUrl5="https://www.hotelmycamp.com/#";
        Assert.assertEquals(actualUrl5,expectedUrl5);








    }


}









