package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelMyCampRoomReservation {

    public HotelMyCampRoomReservation() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //               USER STORY 8  9  VE  10         //
    //               Room Reservation               //


    // US_0009
    @FindBy(xpath = "//option[@value='-1']")
    public WebElement viewAllButtonFirst;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rawsList1;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> dataList1;

    @FindBy(xpath = "//div[contains(@class,'col-md-8 col-sm-12')]//button[contains(@class,'btn green')][normalize-space()='Save']")
    public WebElement saveButtonGeneralData;

    @FindBy(xpath = "//button[@onclick='javascript:AddBarcode();return false;']")
    public WebElement saveButtonProperty;

    @FindBy(xpath = "//option[@value='-1']")
    public WebElement viewAllButtonSecond;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> rawsList2;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> dataList2;

    @FindBy(id = "btnDelete")  // //button[@id='btnDelete']
    public WebElement deleteButton;

    @FindBy(xpath ="(//div[@id='frmBody'])[1]")
    public WebElement createHotelroomreservatıonFormu;

    @FindBy(xpath = "(//select[@title='Select User'])[1]")
    public WebElement idUserilk;

    @FindBy(linkText = "manager")
    public WebElement idUserManager;

    @FindBy(xpath = "(//select[@title='Select HotelRoom'])[1]")
    public WebElement idUserikinci;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement reservationPrice;

    @FindBy(xpath = "//div[@id='uniform-IsPaid']")
    public WebElement isPaidKutucugu;

    @FindBy(xpath = "(//button[@id='btnSubmit'])[1]")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[.='RoomReservation was inserted successfully']")
    public WebElement reservationOnayYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement onayOkTusu;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement createHotelroomreservationText;


    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement selectUserDropDown;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement selectHotelDropDown;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement priceBoxElementi;

    @FindBy(xpath = "//input[@id='DateStart']")
    public WebElement startDateBox;

    @FindBy(xpath = "//input[@id='DateEnd']")
    public WebElement endDateBox;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement adultAmountBox;

    @FindBy(xpath = "//div[@class='modal-body']")
    public WebElement alertYazisiElementi;

    @FindBy(xpath = "//input[@name='ContactNameSurname']")
    public WebElement contactNameSurnameSearchBox;

    @FindBy(xpath = "//tbody/tr[1]/td[9]")
    public WebElement webtableContactName;

    @FindBy(xpath = "//tbody/tr[1]/td[10]")
    public WebElement webtableContactPhone;

    @FindBy(xpath = "//tbody/tr[1]/td[11]")
    public WebElement webtableContactEmail;




    ///////////////////////////////////YENI KULLANICI OLUSTURMA /////////////////////////////

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement createNewAccountUserNameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement createNewAccountPasswordBox;

    @FindBy(xpath = "//a[@class='btn-custom']")
    public WebElement createNewAccountButton;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement createNewAccountEmailBox;

    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement createNewAccountFullName;

    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement createNewAccountPhoneBox;

    @FindBy(xpath = "//input[@id='SSN']")
    public WebElement createNewAccountSocialSecurityNumber;

    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement createNewAccountDrivingLicenceBox;

    @FindBy(xpath = "//select[@id='IDCountry']")
    public WebElement createNewAccountCountryDropDown;

    @FindBy(xpath = "//select[@id='IDState']")
    public WebElement createNewAccountStateDropDown;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement createNewAccountAddressBox;

    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement createNewAccountWorkingSector;

    @FindBy(xpath = "//input[@id='BirthDate']")
    public WebElement createNewAccountBirthday; // ay/gun/yil

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement createNewAccountSaveButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement createNewAccountAlertOkButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement createnewAccountAlertSuccessText;

    ///////////////////////////////////YENI KULLANICI OLUSTURMA KAPANIS /////////////////////////////


    @FindBy(xpath = "//a[text()='Reservations']")
    public WebElement userReservationButton;

    //@FindBy(xpath = "")








}