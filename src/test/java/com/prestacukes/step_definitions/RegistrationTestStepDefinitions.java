package com.prestacukes.step_definitions;

import com.github.javafaker.Faker;
import com.prestacukes.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.prestacukes.utilities.BrowserUtils.waitForElementTextToMatch;

public class RegistrationTestStepDefinitions {
    public static String userName;
    public static String passWord;
    public static String firstName;
    public static String lastName;
    public static String address;
    public static String city;
    public static String state;
    public static String zipcode;
    public static String phone;
    public static String alias;
    public static String email;
    public static String country;


    @When ( "selects Create Account" )
    public void selects_Create_Account ( ) {
        SignIn signIn = new SignIn ( );
        Faker faker = new Faker ( );
        signIn.createAccountBox.sendKeys ( email = faker.internet ( ).emailAddress ( ) );
        signIn.createAccountButton.click ();
    }

    @Then ( "email link should display current email" )
    public void email_link_should_display_current_email ( ) {
        CreateAccount createAccount = new CreateAccount ( );
        waitForElementTextToMatch(createAccount.emailBox, 10,"value", email);
        createAccount.emailBox.getAttribute ( "value" ).trim ( );
    }

    @When ( "user fills out Account Information" )
    public void user_fills_out_Account_Information ( ) {
        CreateAccount createAccount = new CreateAccount ( );
        Faker faker = new Faker ( );
        passWord = faker.internet ( ).password ( 8 , 12 );
        firstName = faker.name ( ).firstName ( );
        lastName = faker.name ( ).lastName ( );
        userName = firstName + " " + lastName;
        address = faker.hitchhikersGuideToTheGalaxy ( ).location ( ) + " " + faker.address ( ).streetSuffix ( );
        city = faker.address ( ).city ( );
        state = faker.address ( ).state ( ).trim ( );
        zipcode = faker.address ( ).zipCode ( ).replaceAll ( "\\D+" , "" ).substring ( 0 , 5 );
        phone = faker.phoneNumber ( ).cellPhone ( );
        alias = faker.space ( ).starCluster ( );
        country = createAccount.getCountry ( ).getAttribute ( "innerText" );

        createAccount.firstNameBox.sendKeys ( firstName );
        createAccount.lastNameBox.sendKeys ( lastName );
        createAccount.passwordBox.sendKeys ( passWord );
        createAccount.firstName_addressBox.sendKeys ( "" );
        createAccount.lastName_addressBox.sendKeys ( "" );
        createAccount.addressBox_Line1.sendKeys ( address );
        createAccount.cityBox.sendKeys ( city );
        createAccount.selectState ( state );
        createAccount.zipCodeBox.sendKeys ( zipcode );
        createAccount.mobilePhoneBox.sendKeys ( phone );
        createAccount.aliasBox.sendKeys ( alias );


    }

    @When ( "selects Register" )
    public void selects_Register ( ) {
        CreateAccount createAccount = new CreateAccount ( );
        createAccount.registerButton.click ( );
    }

    @Then("new username should be displayed next to sign out link")
    public void new_username_should_be_displayed_next_to_sign_out_link() {
        MyAccount myAccount = new MyAccount ();
        Assert.assertEquals ( myAccount.header_userName.getAttribute ( "value" ).trim (),userName );
    }



    @Then ( "users personal information is displayed correctly" )
    public void users_personal_information_is_displayed_correctly ( ) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo ( );
        Assert.assertEquals ( myPersonalInfo.firstNameBox.getAttribute ( "value" ).trim ( ) , firstName );
        Assert.assertEquals ( myPersonalInfo.lastNameBox.getAttribute ( "value" ).trim ( ) , lastName );
        Assert.assertEquals ( myPersonalInfo.emailBox.getAttribute ( "value" ).trim ( ) , email );


    }

    @Then ( "address information should be displayed correctly" )
    public void address_information_should_be_displayed_correctly ( ) {
        MyAddresses myAddresses = new MyAddresses ( );

        Assert.assertEquals ( myAddresses.address_firstName.getAttribute ( "innerText" ).trim ( ) , firstName );
        Assert.assertEquals ( myAddresses.address_lastName.getAttribute ( "innerText" ).trim ( ) , lastName );
        Assert.assertEquals ( myAddresses.address_lineOne.getAttribute ( "innerText" ).trim ( ) , address );
        Assert.assertEquals ( myAddresses.address_city.getAttribute ( "innerText" ).replaceAll ( "," , "" ).trim ( ) , city );
        Assert.assertEquals ( myAddresses.address_state.getAttribute ( "innerText" ).trim ( ) , state );
        Assert.assertEquals ( myAddresses.address_zipCode.getAttribute ( "innerText" ).trim ( ) , zipcode );
        Assert.assertEquals ( myAddresses.adress_country.getAttribute ( "innerText" ).trim ( ) , country );
        Assert.assertEquals ( myAddresses.address_mobilePhone.getAttribute ( "innerText" ).trim ( ) , phone );

    }

    @When ( "user selects sign-out link" )
    public void user_selects_sign_out_link ( ) {
        MyAddresses myAddresses = new MyAddresses ( );
        myAddresses.signOut_button.click ( );


    }

    @When ( "user logs back in with valid credentials" )
    public void user_logs_back_in_with_valid_credentials ( ) {
        SignIn signIn = new SignIn ( );
        signIn.registeredEmailBox.sendKeys ( email );
        signIn.registeredPassword.sendKeys ( passWord );
        signIn.signInButton.click ( );


    }


    @Then("current username should be displayed next to sign out link")
    public void current_username_should_be_displayed_next_to_sign_out_link() {
        MyAccount myAccount = new MyAccount ();
        Assert.assertEquals ( myAccount.header_userName.getAttribute ( "value" ).trim (),userName );
    }


}
