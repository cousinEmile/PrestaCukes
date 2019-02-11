package com.prestacukes.step_definitions;

import com.prestacukes.pages.QuickViewFrame;
import com.prestacukes.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static com.prestacukes.step_definitions.ProductInformation_PriceStepDefinitions.namePreClick;
import static com.prestacukes.step_definitions.ProductInformation_PriceStepDefinitions.pricePreClick;
import static com.prestacukes.utilities.ApplicationConstants.*;
import static com.prestacukes.utilities.BrowserUtils.*;

public class ProductInformation_AddToCartStepDefinitions {

    @Given ( "that user adds current item to cart" )
    public void that_user_adds_current_item_to_cart ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );
        Driver.getDriver ().switchTo ().frame ( quickViewFrame.iframe );
        quickViewFrame.addToCart_button.click ( );
    }

    @Then ( "confirmation message should match ADDTOCART_MSG" )
    public void confirmation_message_should_match_ADDTOCART_MSG ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );
        waitForElementTextToMatch(quickViewFrame.productAddedSuccessMsg,10,"innerText", ADDTOCART_MSG);
        System.out.println ( quickViewFrame.productAddedSuccessMsg.getAttribute ( "innerText" ).trim ( ));
       // Assert.assertEquals ( quickViewFrame.productAddedSuccessMsg.getAttribute ( "innerText" ).trim ( ) , ADDTOCART_MSG );
    }

    @Then ( "quantity and size should be" )
    public void quantity_and_size_should_be ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );

        Assert.assertEquals ( quickViewFrame.postCartPrice.getAttribute ( "innerText" ).trim ( ) , pricePreClick );
        Assert.assertEquals ( quickViewFrame.postCartProductName.getAttribute ( "innerText" ).trim ( ) , namePreClick );
        Assert.assertEquals ( quickViewFrame.postCartQuantity.getAttribute ( "innerText" ).trim ( ) , DEFAULT_QUANTITY );
        Assert.assertEquals ( quickViewFrame.split ( ) , DEFAULT_SIZE );
    }

}
