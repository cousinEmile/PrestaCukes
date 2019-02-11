package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInfo {
    public MyPersonalInfo ( ) {
        PageFactory.initElements ( Driver.getDriver ( ) , this );
    }

    @FindBy ( xpath = "//input[@id='firstname']" )
    //Assert.assertTrue(firstNameBoxe.getAttribute("value").equals(firstName));
    public WebElement firstNameBox;

    @FindBy ( xpath = "//input[@id='lastname']" )
    //Assert.assertTrue(lastNameBox.getAttribute("value").equals(lastName));
    public WebElement lastNameBox;

    @FindBy ( xpath = "//input[@id='email']" )     //Assert.assertTrue(emailBox.getAttribute("value").equals(eMail));
    public WebElement emailBox;

    @FindBy ( xpath = "//input[@id='old_passwd']" )
    public WebElement currentPassword;

    @FindBy ( xpath = "//ul[@class='footer_links clearfix']/li/a/span[1]" )
    public WebElement backToAccount_button;

    @FindBy ( css = "button.btn.btn-default.button.button-medium" )
    public WebElement save_button;

    @FindBy(css = "div.alert.alert-danger>ol>li")
    public WebElement errorMsg;

}
