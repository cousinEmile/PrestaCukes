package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class QuickViewFrame {
    public QuickViewFrame(){
        PageFactory.initElements( Driver.getDriver(), this);
    }

    @FindBy (xpath = "//p[@id='quantity_wanted_p']/a[2]")    //actions.moveToElement(driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]"))).click().perform();
    public WebElement quantityUp_button;

    @FindBy(xpath = "//p[@id='quantity_wanted_p']/a" )
    public WebElement quantityDown_button;

    ///RANDOM QUANTITY 2 - 5 ////////
    public void randomQuantity_1( WebDriver driver){
        Random random=new Random();
        Actions actions = new Actions( driver);
        int q = random.nextInt(3);
        switch (q) {
            case 0:
                actions.moveToElement(quantityDown_button).click().perform();
                break;
            case 1:
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                break;
            case 2:
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                break;
            case 3:
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                actions.moveToElement(quantityDown_button).click().perform();
                break;
        }
    }

    @FindBy(css = "input#quantity_wanted")
    public WebElement quantityWanted_box;

    @FindBy(tagName = "select")
    public WebElement sizes;

    public String getSize(){
        Select size = new Select( sizes);
        return size.getFirstSelectedOption().getText();
    }

    public List<WebElement> getSizes(){
        Select size = new Select(sizes);
        return size.getOptions();

    }

    public void setSize(){
        Select size = new Select(sizes);
        size.selectByIndex((Math.random() <= 0.5) ? 1 : 2);
    }

    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement addToCart_button;

    @FindBy(className = "fancybox-iframe")
    public WebElement iframe;
    @FindBy(xpath = "//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[4]/span")
    public WebElement continueShopping_button;

    @FindBy(xpath = "//div[@class='button-container']/a")
    public WebElement proceedToCheckout_button;

    @FindBy(xpath = "//div[@class='pb-center-column col-xs-12 col-sm-4']/h1")
    public WebElement productName;  /**  innerText  **/

    @FindBy(css = "span#our_price_display")
    public WebElement itemprice;  /**   innerText   **/

    public void fancyBox(WebDriver driver) {
        driver.switchTo().frame(iframe);
    }

    @FindBy(css = "p#product_reference")
    public WebElement breadcrumb;

    @FindBy(xpath = "(//div[@id='layer_cart']/div/div/h2)[1]")
    public WebElement productAddedSuccessMsg;

    @FindBy(css = "span.cross")
    public WebElement XX;

    @FindBy(css = "span#layer_cart_product_title")
    public WebElement postCartProductName;

    @FindBy(css = "span#layer_cart_product_price")
    public WebElement postCartPrice;

    @FindBy(css = "span#layer_cart_product_quantity")
    public WebElement postCartQuantity;

    @FindBy(css = "span#layer_cart_product_attributes")
    public WebElement postCartSize;

    public String split(){
       String[] ret = postCartSize.getAttribute ( "innerText" ).split ( "," );
       return ret[1].trim ();
    }

    public void pickAndChoose(){
        Random random = new Random();
        quantityWanted_box.clear();
        quantityWanted_box.sendKeys(random.nextInt(6)+1+"");
        setSize();
        addToCart_button.click();
        Assert.assertEquals( productAddedSuccessMsg.getText().trim(), "Product successfully added to your shopping cart");
    }



/*
    actions.moveToElement(driver.findElement(By.xpath("//span[@class='cross']"))).click().perform();
    actions.moveToElement(driver.findElement(By.cssSelector("span.cross"))).doubleClick().perform();
    actions.moveToElement(driver.findElement(By.xpath(" "))).doubleClick().perform();
}
 */
}

