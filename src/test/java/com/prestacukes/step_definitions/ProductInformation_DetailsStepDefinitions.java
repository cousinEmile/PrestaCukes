package com.prestacukes.step_definitions;

import com.prestacukes.pages.QuickViewFrame;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import javafx.scene.web.WebEvent;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.prestacukes.utilities.ApplicationConstants.*;

public class ProductInformation_DetailsStepDefinitions {

    @Given ( "that user has selected a product" )
    public void that_user_has_selected_a_product ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );

        Assert.assertTrue ( quickViewFrame.breadcrumb.isDisplayed ( ) );
    }

    @Then ( "the quantity and size should be DEFAULT" )
    public void the_quantity_and_size_should_be_DEFAULT ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );
        Assert.assertEquals ( quickViewFrame.getSize ( ).trim ( ) , DEFAULT_SIZE );
        Assert.assertEquals ( quickViewFrame.quantityWanted_box.getAttribute ( "value" ).trim ( ) , DEFAULT_QUANTITY );
    }

    @Then ( "the available sizes should match the SIZE_OPTIONS" )
    public void the_available_sizes_should_match_the_SIZE_OPTIONS ( ) {
        QuickViewFrame quickViewFrame = new QuickViewFrame ( );
        List<WebElement> sizes = quickViewFrame.getSizes ( );
        for(int i = 0; i< sizes.size ();i++) {
            Assert.assertEquals (sizes.get ( i ).getText ( ),SIZE_OPTIONS[i].toString ( )  );
            System.out.println ( sizes.get ( i ).getText ( ) + " | " + SIZE_OPTIONS[i].toString ( ) );
        }



        }


    }



