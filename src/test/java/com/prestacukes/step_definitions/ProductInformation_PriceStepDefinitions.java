package com.prestacukes.step_definitions;

import com.prestacukes.pages.Products;
import com.prestacukes.pages.QuickViewFrame;
import com.prestacukes.utilities.ConfigurationReader;
import com.prestacukes.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProductInformation_PriceStepDefinitions {
    public static String pricePreClick;
    public static String pricePostClick;
    public static String namePreClick;
    public static String namePostClick;

    @Given ( "user is on homepage" )
    public void user_is_on_homepage ( ) {
        Driver.getDriver ( ).get ( ConfigurationReader.getProperties ( "url" ) );

    }

    @When ( "user selects an item" )
    public void user_selects_an_item ( ) {
        Products products = new Products ( );

        namePreClick = products.Tshirt.getAttribute ( "title" ).trim ( );
        pricePreClick = products.TshirtPrice.getAttribute ( "innerText" ).trim ( );
        products.quickView.click ( );
    }

    @Then ( "product information should be displayed" )
    public void product_information_should_be_displayed ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );

        Driver.getDriver ( ).switchTo ( ).frame ( quickViewFrame.iframe );
        pricePostClick = quickViewFrame.itemprice.getAttribute ( "innerText" ).trim ( );
        namePostClick = quickViewFrame.productName.getAttribute ( "innerText" ).trim ( );

    }

    @Then ( "product info should match homepage info" )
    public void product_info_should_match_homepage_info ( ) {

        Assert.assertEquals ( pricePreClick , pricePostClick );
        Assert.assertEquals ( namePreClick , namePostClick );
    }


}
