package com.prestacukes.olympic_steps;

import com.prestacukes.utilities.Driver;
import com.prestacukes.utilities.OlympicQuarterly;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

public class SortTestSteps {


    @Given ("that user is at homepage")
    public void that_user_is_at_homepage() {

        Driver.getDriver ( ).get ( OlympicQuarterly.getIOCproperties ( "url" ) );

    }

    @Then ("verify that Medal Table is sorted by rank")
    public void verify_that_Medal_Table_is_sorted_by_rank( Map<String, String> ranks ) {





    }

    @When ("user clicks NOC link")
    public void user_clicks_NOC_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("table should be sorted by country names")
    public void table_should_be_sorted_by_country_names() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Rank column is not in ascending order anymore")
    public void rank_column_is_not_in_ascending_order_anymore() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
