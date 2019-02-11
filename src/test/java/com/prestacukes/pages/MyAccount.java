package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
    public MyAccount(){
        PageFactory.initElements( Driver.getDriver(), this);
    }

    @FindBy (css = "div.row>nav>div:first-of-type")      //.getText(), userName);
    public WebElement header_userName;

    @FindBy(xpath = "//ul[@class='myaccount-link-list']/li[4]/a")       //.click();
    public WebElement myPersonlInfo_button;

    @FindBy(xpath = "//ul[@class='myaccount-link-list']/li[3]/a")
    public WebElement myAddresses_button;

    @FindBy(xpath = "//div[@class='cart_block block exclusive']/div/div/dl/dt/a")
    public WebElement hoverCartIcon_productName;

    @FindBy(css = "div.shopping_cart")
    public WebElement hover_Cart_Icon_button;

    @FindBy(css = "div#header_logo>a>img")
    public WebElement logohome;






}
