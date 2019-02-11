package com.prestacukes.step_definitions;

import com.prestacukes.pages.MyAccount;
import com.prestacukes.pages.MyAddresses;
import com.prestacukes.pages.YourAddresses;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.prestacukes.utilities.ApplicationConstants.YOURADDRESS_ERROR;

public class Login_MyAddressesStepDefinitions {

    @Given ("user selects My Addresses")
    public void user_selects_My_Addresses() {
        MyAccount myAccount = new MyAccount ();
        myAccount.myAddresses_button.click ();

    }

    @When("user selects Add a new address")
    public void user_selects_Add_a_new_address() {
        MyAddresses myAddresses = new MyAddresses ();
        myAddresses.newAddress_button.click ();
    }

    @When ("user deletes the first name")
    public void user_deletes_the_first_name() {
        YourAddresses yourAddresses = new YourAddresses ();
        yourAddresses.firstname_box.clear ();


    }

    @When("clicks save")
    public void clicks_save() {
        YourAddresses yourAddresses = new YourAddresses ();
        yourAddresses.save_button.click ();



    }

    @Then ("error message should contain MYADDRESS_ERROR")
    public void error_message_should_contain_MYADDRESS_ERROR() {
        YourAddresses yourAddresses = new YourAddresses ();
        Assert.assertEquals ( yourAddresses.error_message.getAttribute ( "innerText" ).trim (),YOURADDRESS_ERROR);


    }

}
