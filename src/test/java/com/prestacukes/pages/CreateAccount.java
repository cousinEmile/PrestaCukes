package com.prestacukes.pages;

import com.github.javafaker.Faker;
import com.prestacukes.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
    public CreateAccount ( ) {
        PageFactory.initElements ( Driver.getDriver ( ) , this );
    }

    Faker    faker    = new Faker ( );
    //For Create Account Method
    Products homePage = new Products ( );
    SignIn   signin   = new SignIn ( );


    @FindBy ( xpath = "//input[@id='id_gender1']" )
    public WebElement Mr_button;

    @FindBy ( xpath = "//input[@id='id_gender2']" )
    public WebElement Mrs_button;

    @FindBy ( xpath = "//input[@id='customer_firstname']" )
    public WebElement firstNameBox;

    @FindBy ( xpath = "//input[@id='customer_lastname']" )
    public WebElement lastNameBox;

    @FindBy ( xpath = "//div[@class='account_creation']/div[4]/input" )
    //.getAttribute("value")    ///Assert.assertTrue(emailBox.getAttribute("value").equals(eMail));
    public WebElement emailBox;

    @FindBy ( xpath = "//input[@id='passwd']" )
    public WebElement passwordBox;

    @FindBy ( id = "days" )
    public WebElement Days;

    public void setDays ( String day ) {
        Select days = new Select ( Days );     //Select Day
        days.selectByVisibleText ( day );
    }

    @FindBy ( id = "months" )
    public WebElement Months;

    public void setMonthsnths ( String mth ) {
        Select months = new Select ( Months );     //Select Month
        months.selectByVisibleText ( mth );
    }

    @FindBy ( id = "years" )
    public WebElement Years;

    public void setYears ( String yrs ) {
        Select years = new Select ( Years );       //Select Year
        years.selectByVisibleText ( yrs );
    }


///////////ADDRESS ////////////

    @FindBy ( xpath = "//input[@id='firstname']" )
    public WebElement firstName_addressBox;

    @FindBy ( xpath = "//input[@id='lastname']" )
    public WebElement lastName_addressBox;

    @FindBy ( xpath = "//input[@id='address1']" )
    public WebElement addressBox_Line1;

    @FindBy ( xpath = "//input[@id='city']" )
    public WebElement cityBox;

    @FindBy ( id = "id_state" )
    public WebElement State;

    public void selectState ( String visState ) {
        Select state = new Select ( State );               //Select State
        state.selectByVisibleText ( visState );
    }

    @FindBy ( xpath = "//input[@id='postcode']" )
    public WebElement zipCodeBox;

    @FindBy ( css = "select#id_country" )
    public WebElement dd_country;

    public WebElement getCountry ( ) {
        Select country = new Select ( dd_country );
        return country.getFirstSelectedOption ( );
    }

    @FindBy ( xpath = "//textarea[@id='other']" )
    public WebElement additionalInfoBox;

    @FindBy ( xpath = "//input[@id='phone_mobile']" )
    public WebElement mobilePhoneBox;

    @FindBy ( xpath = "//input[@id='alias']" )
    public WebElement aliasBox;

    @FindBy ( xpath = "//button[@id='submitAccount']" )
    public WebElement registerButton;


    @FindBy ( xpath = "//div[@class='alert alert-danger']/ol/li" )     //.getText().trim();
    public WebElement errorMsg_firstname$is$required;

    @FindBy ( xpath = "//div[@class='alert alert-danger']/ol/li" )
    public WebElement redAlert;


    public void validAccountFromMainPage ( WebDriver driver , String email , String password , String firstName , String lastName , String userName ) {
        homePage.signInButton.click ( );
        signin.createAccountBox.sendKeys ( email + Keys.ENTER );

        Mr_button.click ( );
        firstNameBox.sendKeys ( firstName );
        lastNameBox.sendKeys ( lastName );
        passwordBox.sendKeys ( password );
        firstName_addressBox.sendKeys ( firstName );
        lastName_addressBox.sendKeys ( lastName );
        addressBox_Line1.sendKeys ( faker.lebowski ( ).character ( ) );
        cityBox.sendKeys ( faker.ancient ( ).god ( ) );
        selectState ( "Maine" );
        zipCodeBox.sendKeys ( "04568" );
        additionalInfoBox.sendKeys ( faker.lebowski ( ).character ( ).concat ( faker.lebowski ( ).quote ( ) ) );
        mobilePhoneBox.sendKeys ( faker.phoneNumber ( ).cellPhone ( ) );
        aliasBox.sendKeys ( faker.ancient ( ).primordial ( ) );
        registerButton.click ( );
        signin.registeredEmailBox.sendKeys ( email );
        signin.registeredPassword.sendKeys ( password );
        signin.signInButton.click ( );
    }

}