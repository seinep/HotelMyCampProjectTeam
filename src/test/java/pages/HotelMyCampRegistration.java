package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampRegistration {


    public HotelMyCampRegistration() {

        PageFactory.initElements(Driver.getDriver(), this);



    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Create a new account']")
    public WebElement createNewAccButton;
    @FindBy(xpath = "//h2[text()='Registration Form']")
    public WebElement registrationFormBaslikYazisi;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameTextBox;
    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='NameSurname']")
    public WebElement fullnameTextBox;
    @FindBy(xpath = "//input[@id='PhoneNo']")
    public WebElement phoneNoTextBox;
    @FindBy(xpath = "//input[@id='SSN']")
    public WebElement snnTextBox;
    @FindBy(xpath = "//input[@id='DrivingLicense']")
    public WebElement drivingLicenseTextBox;
    @FindBy(xpath = "(//select[@class='form-control input-lg required'])[1]")
    public WebElement countryDropdown;
    @FindBy(xpath = "(//select[@class='form-control input-lg required'])[2]")
    public WebElement stateDropdown;
    @FindBy(xpath = "//input[@id='Address']")
    public WebElement addresTextBox;
    @FindBy(xpath = "//input[@id='WorkingSector']")
    public WebElement workingSectorTextBox;
    @FindBy(xpath = "//input[@id='BirthDate']")
    public WebElement birthDateTextBox;
    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement saveButton;
    @FindBy(xpath = "(//div[text()='User Data was inserted successfully'])[2]")
    public WebElement sonucYazisiElement;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement sonucOkeyButton;







}
