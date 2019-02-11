package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddresses {
    public MyAddresses(){
        PageFactory.initElements( Driver.getDriver(), this);
    }

    @FindBy (xpath = "//ul[@class='last_item item box']/li[2]/span")        //.getAttribute("innerText")
    public WebElement address_firstName;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[2]/span[2]")           //.getAttribute("innerText")
    public WebElement address_lastName;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[4]/span")     //.getAttribute("innerText")
    public WebElement address_lineOne;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[5]/span")     //.getAttribute("innerText")
    public WebElement address_city;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[5]/span[2]")      //.getAttribute("innerText")
    public WebElement address_state;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[5]/span[3]")      //.getAttribute("innerText")
    public WebElement address_zipCode;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[6]/span")     //.getAttribute("innerText")
    public WebElement adress_country;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[8]/span")     //.getAttribute("innerText")
    public WebElement address_mobilePhone;

    @FindBy(xpath = "//ul[@class='last_item item box']/li[9]/a")        //.getAttribute("innerText")
    public WebElement address_update_button;

    @FindBy(xpath = "//div[@class='header_user_info'][2]/a")
    public WebElement signOut_button;

    @FindBy(css = "div.clearfix.main-page-indent>a")
    public WebElement newAddress_button;















}
