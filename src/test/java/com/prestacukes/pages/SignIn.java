package com.prestacukes.pages;

import com.github.javafaker.Faker;
import com.prestacukes.utilities.ConfigurationReader;
import com.prestacukes.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn  {
    Faker faker = new Faker ();
    public SignIn ( ) {
        PageFactory.initElements ( Driver.getDriver ( ) , this );
    }


    @FindBy ( xpath = "//input[@class='is_required validate account_input form-control']" )    //sendkeys
    public WebElement createAccountBox;

    @FindBy ( css = "#SubmitCreate" )   //click
    public WebElement createAccountButton;

    @FindBy ( css = "#email" )
    public WebElement registeredEmailBox;

    @FindBy ( xpath = "//input[@id='passwd']" )
    public WebElement registeredPassword;

    @FindBy ( css = "#SubmitLogin" )
    public WebElement signInButton;

    public void loginWithParams ( String username , String password ) {
        registeredEmailBox.sendKeys ( username );
        registeredPassword.sendKeys ( password );
        signInButton.click ( );
    }

    public void loginWithProperties ( ) {
        registeredEmailBox.sendKeys ( ConfigurationReader.getProperties ( "username" ) );
        registeredPassword.sendKeys ( ConfigurationReader.getProperties ( "password" ) );
        signInButton.click ( );
    }


    //public void staticValidLogin(WebDriver driver, String email, String password, String userName){ <---//** NEED TO REWORK WITHOUT CALLING PRODUCTS PAGE *///*
//
//    registeredEmailBox.sendKeys(email);
//    registeredPassword.sendKeys(password);
//    signInButton.click();
//}
    public void validLogin ( WebDriver driver ) {
        String eMail = faker.internet ( ).emailAddress ( );

        createAccountBox.sendKeys ( eMail + Keys.ENTER );


    }
}
