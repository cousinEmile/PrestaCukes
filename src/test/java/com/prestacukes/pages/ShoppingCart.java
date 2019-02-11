package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

    public ShoppingCart(){
        PageFactory.initElements( Driver.getDriver(), this);
    }

    @FindBy (css ="span.heading-counter")
    public WebElement cartSummary;

    @FindBy(css ="img.logo.img-responsive" )
    public WebElement logoHome;

    @FindBy(css = "div.shopping_cart>a")
    public WebElement hoverCart;

    @FindBy(xpath = "//div[@class='cart_block block exclusive']/div//a/img")  //getAttribute("alt")
    public WebElement hoverCart_productName;

    @FindBy(css = "span.ajax_cart_no_product")
    public WebElement hoverCart_empty;

    @FindBy(css = "span.remove_link>a")
    public WebElement deleteFromHoverCart;

    @FindBy(css = "p.alert.alert-warning")
    public WebElement emptyCartAlert;

    @FindBy(css = "a.logout")
    public WebElement logout;

}
