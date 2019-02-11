package com.prestacukes.step_definitions;

import com.prestacukes.pages.MyAccount;
import com.prestacukes.pages.MyPersonalInfo;
import com.prestacukes.utilities.ConfigurationReader;
import com.prestacukes.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.prestacukes.utilities.ApplicationConstants.IDENTITY_ERROR;
import static com.prestacukes.utilities.ApplicationConstants.MYPERSONALINFO_TITLE;

public class Login_MyPersonalInformationStepDefinitions {

    @Given ( "that user selects My Personal Information" )
    public void that_user_selects_My_Personal_Information ( ) {
        MyAccount myAccount = new MyAccount ( );

        myAccount.myPersonlInfo_button.click ( );


    }

    @Then ( "title should match MYPERSONALINFO_TITLE" )
    public void title_should_match_MYPERSONALINFO_TITLE ( ) {
        Assert.assertEquals ( Driver.getDriver ( ).getTitle ( ).trim ( ) , MYPERSONALINFO_TITLE );


    }

    @Then ( "first and last name should match username on header" )
    public void first_and_last_name_should_match_username_on_header ( ) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo ( );
        Assert.assertEquals ( myPersonalInfo.firstNameBox.getAttribute ( "value" ) , ConfigurationReader.getProperties ( "firstname" ) );
        Assert.assertEquals ( myPersonalInfo.lastNameBox.getAttribute ( "value" ) , ConfigurationReader.getProperties ( "lastname" ) );

    }

    @When ( "user selects save" )
    public void user_selects_save ( ) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo ( );
        myPersonalInfo.save_button.click ();


    }

    @Then ( "error message shold match IDENTITY_ERROR" )
    public void error_message_shold_match_IDENTITY_ERROR ( ) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo ( );
       Assert.assertEquals ( myPersonalInfo.errorMsg.getAttribute ( "innerText" ).trim (), IDENTITY_ERROR );
    }

    @When ( "user selects Back to your Account" )
    public void user_selects_Back_to_your_Account ( ) {
        MyPersonalInfo myPersonalInfo = new MyPersonalInfo ( );
        myPersonalInfo.backToAccount_button.click ();

    }

}
