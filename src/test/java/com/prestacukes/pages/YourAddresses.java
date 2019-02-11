package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddresses {
    public YourAddresses (){
        PageFactory.initElements ( Driver.getDriver ( ), this );
    }

    @FindBy(css ="input#firstname" )
    public WebElement firstname_box;

    @FindBy(css = "button#submitAddress")
    public WebElement save_button;

    @FindBy(css = "div.alert.alert-danger>ol>li:first-of-type")
    public WebElement error_message;




}
