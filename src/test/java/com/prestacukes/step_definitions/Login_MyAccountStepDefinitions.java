package com.prestacukes.step_definitions;

import com.prestacukes.pages.MyAccount;
import com.prestacukes.pages.Products;
import com.prestacukes.pages.SignIn;
import com.prestacukes.utilities.ConfigurationReader;
import com.prestacukes.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.prestacukes.utilities.ApplicationConstants.MYACCOUNT_TITLE;

public class Login_MyAccountStepDefinitions {

    @Given ("that user is on the homepage")
    public void that_user_is_on_the_homepage() {
        Driver.getDriver ().get ( ConfigurationReader.getProperties ( "url" ) );


    }

    @When ("user selects the sign-in link")
    public void user_selects_the_sign_in_link() {
        Products products = new Products ();

        products.signInButton.click ();



    }

    @When("enters valid credentials")
    public void enters_valid_credentials() {
        SignIn signIn = new SignIn ();

        signIn.registeredEmailBox.sendKeys ( ConfigurationReader.getProperties ( "email" ) );
        signIn.registeredPassword.sendKeys ( ConfigurationReader.getProperties ( "password" ) );
        signIn.signInButton.click ();

    }

    @Then ("the title should match MYACCOUNT_TITLE")
    public void the_title_should_match_MYACCOUNT_TITLE() {
        Assert.assertEquals ( Driver.getDriver ().getTitle (), MYACCOUNT_TITLE);
    }

    @Then("username should be displayed next to sign out link")
    public void username_should_be_displayed_next_to_sign_out_link() {
        MyAccount myAccount = new MyAccount ();

        Assert.assertEquals ( myAccount.header_userName.getAttribute ( "innerText" ).trim (),ConfigurationReader.getProperties ( "username" ) );
    }



}
